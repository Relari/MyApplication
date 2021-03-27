package com.pe.relari.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import com.pe.relari.myapplication.business.model.api.EmployeeRequest
import com.pe.relari.myapplication.view.EmployeeView

class EmployeeRegister : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_register)

        val employeeView = EmployeeView()

        val btnRegister = findViewById<Button>(R.id.btnRegister)
        btnRegister.setOnClickListener {

            val employeeRequest = buildEmployeeRequest()

//            employeeView.save(employeeRequest)
            employeeView.save2(employeeRequest)

            Toast.makeText(this, employeeRequest.toString(), Toast.LENGTH_LONG).show()
        }

    }

    private fun buildEmployeeRequest(): EmployeeRequest {

        val txtName = findViewById<TextView>(R.id.txtName)
        val txtPosition = findViewById<TextView>(R.id.txtPosition)
        val txtGender = findViewById<Spinner>(R.id.txtGender)
        val txtSalary = findViewById<TextView>(R.id.txtSalary)

        val genderCode = findByGenderDescription(txtGender.selectedItem.toString())

        return EmployeeRequest(
            txtName.text.toString(),
            txtPosition.text.toString(),
            genderCode,
            txtSalary.text.toString().toDouble())

    }

    private fun genders(): List<Gender> {

        val gender1 = Gender(GenderEnum.M, "Male")
        val gender2 = Gender(GenderEnum.F, "Female")

        return listOf(gender1, gender2)
    }

    private fun findByGenderDescription(genderDescription: String): String {
        return genders()
            .filter { it.description == genderDescription }
            .map { it.code.name }
            .first()
    }

}

data class Gender(val code: GenderEnum, val description: String)

enum class GenderEnum { M, F }