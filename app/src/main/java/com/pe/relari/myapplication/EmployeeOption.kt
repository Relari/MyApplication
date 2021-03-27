package com.pe.relari.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class EmployeeOption : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_option)

        val register = findViewById<Button>(R.id.btnNextRegister)
        val report = findViewById<Button>(R.id.btnNextReport)

        register.setOnClickListener {
            startActivity(Intent(this, EmployeeRegister::class.java))
        }

        report.setOnClickListener {
            startActivity(Intent(this, EmployeeReport::class.java))
        }
    }
}
