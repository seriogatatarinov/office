package ru.st.office.service

import ru.st.office.demo.entities.EmployeeEntity
import java.util.*

interface EmployeeService {

    fun save(employee: EmployeeEntity): EmployeeEntity

    fun findById(id: Long): Optional<EmployeeEntity>

    fun deleteById(id: Long)

    fun findAll(): List<EmployeeEntity>
}