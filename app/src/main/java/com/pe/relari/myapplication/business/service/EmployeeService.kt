package com.pe.relari.myapplication.business.service

import com.pe.relari.myapplication.business.model.business.Employee

interface EmployeeService {

  fun save(employee: Employee)

  fun findAll(): List<Employee>
}
