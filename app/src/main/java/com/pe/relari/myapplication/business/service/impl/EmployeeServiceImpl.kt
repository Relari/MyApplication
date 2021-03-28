package com.pe.relari.myapplication.business.service.impl

import com.pe.relari.myapplication.business.dao.EmployeeDao
import com.pe.relari.myapplication.business.dao.impl.EmployeeDaoImpl
import com.pe.relari.myapplication.business.model.business.Employee
import com.pe.relari.myapplication.business.service.EmployeeService

class EmployeeServiceImpl(
  private val employeeDao: EmployeeDao = EmployeeDaoImpl()) : EmployeeService {

  override fun save(employee: Employee) {
    employeeDao.save(employee)
  }

  override fun findAll(): List<Employee> {
    return employeeDao.findAll()
  }

}
