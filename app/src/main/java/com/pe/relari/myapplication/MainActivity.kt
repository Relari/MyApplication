package com.pe.relari.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.pe.relari.myapplication.business.model.api.EmployeeRequest
import com.pe.relari.myapplication.view.EmployeeView

class MainActivity : AppCompatActivity() {

    var txtName : TextView = findViewById(R.id.txtName)
    var txtPosition : TextView = findViewById(R.id.txtPosition)
    var txtSex : TextView = findViewById(R.id.txtSex)
    var txtSalary : TextView = findViewById(R.id.txtSalary)
    var btnRegister : Button = findViewById(R.id.btnRegister)

    private val employeeView: EmployeeView = EmployeeView()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRegister.setOnClickListener {

            //employeeView.save(buildEmployeeRequest())

            employeeView.save2(buildEmployeeRequest())
        }

    }

    private fun buildEmployeeRequest(): EmployeeRequest {
        return EmployeeRequest(
            txtName.getText().toString(),
            txtPosition.getText().toString(),
            txtSex.getText().toString(),
            txtSalary.getText().toString().toDouble())

    }
}
