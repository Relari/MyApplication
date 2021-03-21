package com.pe.relari.myapplication.business.dao.impl

import com.pe.relari.myapplication.business.dao.EmployeeDao
import com.pe.relari.myapplication.business.model.business.Employee
import com.pe.relari.myapplication.business.model.entity.EmployeeEntity
import com.pe.relari.myapplication.config.RestConfiguration
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class EmployeeDaoImpl(private val restConfiguration: RestConfiguration = RestConfiguration()) : EmployeeDao {

  override fun findAll(): Observable<Employee> {
    return restConfiguration.employeeRepository().findAll()
            .subscribeOn(Schedulers.io())
            .flatMapIterable { it }
            .map { mapEmployee(it) }
  }

  private fun mapEmployee(employeeEntity: EmployeeEntity): Employee {
    return Employee(
        employeeEntity.name,
        employeeEntity.position,
        employeeEntity.sex,
        employeeEntity.salary,
        employeeEntity.status)
  }

  override fun save(employee: Employee): Completable {
    return Single.fromCallable { mapEmployeeEntity(employee) }
            .flatMapCompletable{ restConfiguration.employeeRepository().save(it) }
            .subscribeOn(Schedulers.io())
  }

  override fun save2(employee: Employee) {
      val employeeEntity = mapEmployeeEntity(employee)
      restConfiguration.employeeRepository().save2(employeeEntity)
  }


  private fun mapEmployeeEntity(employee: Employee): EmployeeEntity {
    return EmployeeEntity(
        "",
        employee.name,
        employee.position,
        employee.sex,
        employee.salary,
        employee.status)
  }
}
