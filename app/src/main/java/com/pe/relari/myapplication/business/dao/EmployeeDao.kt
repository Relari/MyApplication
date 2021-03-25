package com.pe.relari.myapplication.business.dao


import com.pe.relari.myapplication.business.model.business.Employee
import io.reactivex.Completable
import io.reactivex.Observable

interface EmployeeDao {

  fun findAll(): Observable<Employee>

  fun save(employee: Employee): Completable

  fun save2(employee: Employee)

  fun findAll2(): List<Employee>
}
