package com.pe.relari.myapplication.business.dao.impl

import android.util.Log
import com.google.gson.Gson
import com.pe.relari.myapplication.business.dao.EmployeeDao
import com.pe.relari.myapplication.business.model.business.Employee
import com.pe.relari.myapplication.business.model.entity.EmployeeEntity
import com.pe.relari.myapplication.config.RestConfiguration
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EmployeeDaoImpl(
    private val restConfiguration: RestConfiguration = RestConfiguration()) : EmployeeDao {

  override fun save(employee: Employee) {
      val employeeEntity = mapEmployeeEntity(employee)
      restConfiguration.employeeRepository().save(employeeEntity)
          .enqueue(object : Callback<Void> {
              override fun onFailure(call: Call<Void>?, t: Throwable?) {
                  // failure
                  t?.printStackTrace()
              }

              override fun onResponse(call: Call<Void>?, response: Response<Void>?) {
                  // success
                  val isSave = response?.isSuccessful!!
                  Log.i("Registered employee.", Gson().toJson(MessageResponse(isSave)))
              }
          })
  }

  private fun mapEmployeeEntity(employee: Employee): EmployeeEntity {
    return EmployeeEntity(
        "",
        employee.name,
        employee.position,
        employee.sex,
        employee.salary,
        employee.status)
  }

  override fun findAll(): List<Employee> {

      return listOf(
          Employee("Renzo", "Developer", "M", 3000.0, true),
          Employee("Irene", "Leader", "F", 5000.0, true))
  }

  private fun mapEmployee(employeeEntity: EmployeeEntity): Employee {
    return Employee(
        employeeEntity.name,
        employeeEntity.position,
        employeeEntity.sex,
        employeeEntity.salary,
        employeeEntity.status)
  }
}

data class MessageResponse(val msg: Boolean)
