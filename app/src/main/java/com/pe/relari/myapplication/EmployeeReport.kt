package com.pe.relari.myapplication

import android.util.Log
import com.google.gson.Gson
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pe.relari.myapplication.business.model.business.Employee
import com.pe.relari.myapplication.business.model.entity.EmployeeEntity
import com.pe.relari.myapplication.config.RestConfiguration
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EmployeeReport : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_report)

        val restConfiguration = RestConfiguration()
        restConfiguration.employeeRepository().findAll2()

        restConfiguration.employeeRepository().findAll2()
          .enqueue(object : Callback<List<EmployeeEntity>> {
              override fun onFailure(call: Call<List<EmployeeEntity>>?, t: Throwable?) {
                  // failure
                  t?.printStackTrace()
              }

              override fun onResponse(call: Call<List<EmployeeEntity>>?, response: Response<List<EmployeeEntity>>?) {
                  // success
                  val employees = response?.body()!!
                      .map { mapEmployee(it) }

                  initRecycler(employees)

                  Log.i("Registered employee.", Gson().toJson(employees))
              }
          })

    }

    private fun mapEmployee(employeeEntity: EmployeeEntity): Employee {
        return Employee(
            employeeEntity.name,
            employeeEntity.position,
            employeeEntity.sex,
            employeeEntity.salary,
            employeeEntity.status)
    }

    private fun initRecycler(employees: List<Employee>) {

        val rvEmployees = findViewById<RecyclerView>(R.id.rvEmployees)

        rvEmployees.layoutManager = LinearLayoutManager(this)

        val adapter = EmployeeAdapter(employees)

        rvEmployees.adapter = adapter
    }
}
