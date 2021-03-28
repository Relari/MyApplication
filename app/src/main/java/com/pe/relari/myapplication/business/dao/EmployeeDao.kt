package com.pe.relari.myapplication.business.dao


import com.pe.relari.myapplication.business.model.business.Employee

interface EmployeeDao {

  fun save(employee: Employee)

  fun findAll(): List<Employee>
}
