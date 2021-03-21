package com.pe.relari.myapplication.business.service.impl

import com.pe.relari.myapplication.business.dao.EmployeeDao
import com.pe.relari.myapplication.business.dao.impl.EmployeeDaoImpl
import com.pe.relari.myapplication.business.model.business.Employee
import com.pe.relari.myapplication.business.service.EmployeeService

import io.reactivex.Completable
import io.reactivex.Observable

class EmployeeServiceImpl(private val employeeDao: EmployeeDao = EmployeeDaoImpl()) : EmployeeService {
  override fun save2(employee: Employee) {
    employeeDao.save2(employee)
  }

  override fun save(employee: Employee): Completable {
    return employeeDao.save(employee)
  }

  override fun findAll(): Observable<Employee> {
    return employeeDao.findAll()
  }

}
