package com.pe.relari.myapplication

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pe.relari.myapplication.business.mapper.EmployeeMapper
import com.pe.relari.myapplication.business.model.business.Employee
import com.pe.relari.myapplication.business.model.entity.EmployeeEntity
import com.pe.relari.myapplication.config.RestConfiguration
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG_EMPLOYEE: String = "EMPLOYEE"
class EmployeeReport : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_report)

        val restConfiguration = RestConfiguration()

        restConfiguration.employeeRepository().findAll()
          .enqueue(object : Callback<List<EmployeeEntity>> {
              override fun onFailure(call: Call<List<EmployeeEntity>>?, t: Throwable?) {
                  // failure
                  t?.printStackTrace()
              }

              override fun onResponse(call: Call<List<EmployeeEntity>>?, response: Response<List<EmployeeEntity>>?) {
                  // success
                  val employees = response?.body()!!
                      .map { EmployeeMapper().mapEmployee(it) }
                      .onEach { Log.i(TAG_EMPLOYEE, it.toString()) }

                  initRecycler(employees)

              }
          })

    }

    private fun initRecycler(employees: List<Employee>) {

        val rvEmployees = findViewById<RecyclerView>(R.id.rvEmployees)

        rvEmployees.layoutManager = LinearLayoutManager(this)

        val adapter = EmployeeAdapter(employees)

        rvEmployees.adapter = adapter
    }
}
