package com.pe.relari.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import com.pe.relari.myapplication.view.EmployeeView

class EmployeeReport : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_report)

        val arrayAdapter: ArrayAdapter<String>
        val employees = listOf("Carlos","Laura","Diego","Maria")

        val employeeView = EmployeeView()
        val namesEmployees = employeeView.findAll2()
            .map { it.name }

//        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, employees)
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, namesEmployees)

        val list = findViewById<ListView>(R.id.lvEmployees)
        list.adapter = arrayAdapter

    }
}
