package com.pe.relari.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.pe.relari.myapplication.business.model.api.EmployeeRequest
import com.pe.relari.myapplication.view.EmployeeView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
        val txtSex = findViewById<TextView>(R.id.txtSex)
        val txtSalary = findViewById<TextView>(R.id.txtSalary)

        return EmployeeRequest(
            txtName.text.toString(),
            txtPosition.text.toString(),
            txtSex.text.toString(),
            txtSalary.text.toString().toDouble())

    }
}
