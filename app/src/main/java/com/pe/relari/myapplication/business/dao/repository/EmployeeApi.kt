package com.pe.relari.myapplication.business.dao.repository


import com.pe.relari.myapplication.business.model.entity.EmployeeEntity

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface EmployeeApi {

  @POST("business/firebase/v1/employees")
  fun save(@Body employeeEntity: EmployeeEntity): Call<Void>

  @GET("business/firebase/v1/employees")
  fun findAll(): Call<List<EmployeeEntity>>

}
