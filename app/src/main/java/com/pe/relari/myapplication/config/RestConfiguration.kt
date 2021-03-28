package com.pe.relari.myapplication.config

import com.pe.relari.myapplication.business.dao.repository.EmployeeApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val URI: String = "https://employee-firebase.herokuapp.com/"

class RestConfiguration {

  private fun retrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl(URI)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
  }

  fun employeeRepository(): EmployeeApi {
    return retrofit().create<EmployeeApi> (EmployeeApi::class.java)
  }

}
