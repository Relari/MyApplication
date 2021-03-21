package com.pe.relari.myapplication.view


import com.pe.relari.myapplication.business.model.api.EmployeeRequest
import com.pe.relari.myapplication.business.model.api.EmployeeResponse
import com.pe.relari.myapplication.business.model.business.Employee
import com.pe.relari.myapplication.business.service.EmployeeService
import com.pe.relari.myapplication.business.service.impl.EmployeeServiceImpl
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

class EmployeeView(private val employeeService: EmployeeService = EmployeeServiceImpl()) {


  fun findAll(): Observable<EmployeeResponse> {
    return employeeService.findAll()
            .map { mapEmployeeResponse(it) }
  }

  private fun mapEmployeeResponse(employee: Employee): EmployeeResponse {
        return EmployeeResponse(
            employee.name,
            employee.position,
            employee.sex,
            employee.salary)
  }

  fun save(employeeRequest: EmployeeRequest): Completable {
    return Single.fromCallable { mapEmployee(employeeRequest) }
            .flatMapCompletable(employeeService::save)
  }

  private fun mapEmployee(employeeRequest: EmployeeRequest): Employee {
      return Employee(
          employeeRequest.name,
          employeeRequest.position,
          employeeRequest.sex,
          employeeRequest.salary,
          true)
  }

  fun save2(employeeRequest: EmployeeRequest) {
     val employee = mapEmployee(employeeRequest)
     employeeService.save2(employee)
  }

}
