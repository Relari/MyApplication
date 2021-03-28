package com.pe.relari.myapplication.view


import com.pe.relari.myapplication.business.model.api.EmployeeRequest
import com.pe.relari.myapplication.business.model.api.EmployeeResponse
import com.pe.relari.myapplication.business.model.business.Employee
import com.pe.relari.myapplication.business.service.EmployeeService
import com.pe.relari.myapplication.business.service.impl.EmployeeServiceImpl

class EmployeeView(
    private val employeeService: EmployeeService = EmployeeServiceImpl()) {

  private fun mapEmployeeResponse(employee: Employee): EmployeeResponse {
        return EmployeeResponse(
            employee.name,
            employee.position,
            employee.sex,
            employee.salary)
  }

  private fun mapEmployee(employeeRequest: EmployeeRequest): Employee {
      return Employee(
          employeeRequest.name,
          employeeRequest.position,
          employeeRequest.sex,
          employeeRequest.salary,
          true)
  }

  fun save(employeeRequest: EmployeeRequest) {
     val employee = mapEmployee(employeeRequest)
     employeeService.save(employee)
  }

  fun findAll(): List<EmployeeResponse> {
    return employeeService.findAll()
        .map { mapEmployeeResponse(it) }
  }
}
