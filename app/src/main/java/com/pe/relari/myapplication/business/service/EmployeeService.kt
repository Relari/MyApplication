package com.pe.relari.myapplication.business.service

import com.pe.relari.myapplication.business.model.business.Employee
import io.reactivex.Completable
import io.reactivex.Observable

interface EmployeeService {

  fun findAll(): Observable<Employee>

  fun save(employee: Employee): Completable

  fun save2(employee: Employee)
}
