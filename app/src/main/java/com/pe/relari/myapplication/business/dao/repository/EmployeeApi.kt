package com.pe.relari.myapplication.business.dao.repository


import com.pe.relari.myapplication.business.model.entity.EmployeeEntity

import io.reactivex.Completable
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface EmployeeApi {

  @GET("business/firebase/v1/employees")
  fun findAll(): Observable<List<EmployeeEntity>>

  @POST("business/firebase/v1/employees")
  fun save(@Body employeeEntity: EmployeeEntity): Completable

  @POST("business/firebase/v1/employees")
  fun save2(@Body employeeEntity: EmployeeEntity): Call<Void>

  @GET("business/firebase/v1/employees")
  fun findAll2(): Call<List<EmployeeEntity>>
}
