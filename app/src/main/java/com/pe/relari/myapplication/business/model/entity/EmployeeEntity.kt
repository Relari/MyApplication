package com.pe.relari.myapplication.business.model.entity

data class EmployeeEntity(
  val id: String = "",
  val name: String = "",
  val position: String = "",
  val sex: String = "",
  val salary: Double = 0.0,
  val status: Boolean = true)