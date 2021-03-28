package com.pe.relari.myapplication.business.dao.impl

import android.util.Log
import com.google.gson.Gson
import com.pe.relari.myapplication.business.dao.EmployeeDao
import com.pe.relari.myapplication.business.mapper.EmployeeMapper
import com.pe.relari.myapplication.business.model.business.Employee
import com.pe.relari.myapplication.business.model.business.MessageModel
import com.pe.relari.myapplication.config.RestConfiguration
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG_SAVE : String = "SAVE"
class EmployeeDaoImpl(
    private val restConfiguration: RestConfiguration = RestConfiguration()) : EmployeeDao {

  override fun save(employee: Employee) {
      val employeeEntity = EmployeeMapper().mapEmployeeEntity(employee)
      restConfiguration.employeeRepository().save(employeeEntity)
          .enqueue(object : Callback<Void> {
              override fun onFailure(call: Call<Void>?, t: Throwable?) {
                  // failure
                  t?.printStackTrace()
              }

              override fun onResponse(call: Call<Void>?, response: Response<Void>?) {
                  // success
                  val isSave = response?.isSuccessful!!
                  Log.i(TAG_SAVE, Gson().toJson(MessageModel(isSave)))
              }
          })
  }

  override fun findAll(): List<Employee> {

      return listOf(
          Employee("Renzo", "Developer", "M", 3000.0, true),
          Employee("Irene", "Leader", "F", 5000.0, true))
  }

}
