package com.pe.relari.myapplication.business.model.api

data class EmployeeRequest(
  val name: String = "",
  val position: String = "",
  val sex: String = "",
  val salary: Double = 0.0)