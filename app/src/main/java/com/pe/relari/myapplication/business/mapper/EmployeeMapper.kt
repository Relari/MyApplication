package com.pe.relari.myapplication.business.mapper

import com.pe.relari.myapplication.business.model.business.Employee
import com.pe.relari.myapplication.business.model.entity.EmployeeEntity

private const val EMPTY: String = ""
class EmployeeMapper {

    fun mapEmployeeEntity(employee: Employee): EmployeeEntity {
        return EmployeeEntity(
            EMPTY,
            employee.name,
            employee.position,
            employee.sex,
            employee.salary,
            employee.status)
    }

    fun mapEmployee(employeeEntity: EmployeeEntity): Employee {
        return Employee(
            employeeEntity.name,
            employeeEntity.position,
            employeeEntity.sex,
            employeeEntity.salary,
            employeeEntity.status)
    }

} 