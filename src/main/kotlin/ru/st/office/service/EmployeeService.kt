package ru.st.office.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import ru.st.office.entity.EmployeeEntity
import ru.st.office.dto.EmployeeDto
import ru.st.office.filter.EmployeeCriteria
import java.util.*

interface EmployeeService {

    fun save(employee: EmployeeEntity): EmployeeEntity

    fun findById(id: Long): Optional<EmployeeEntity>

    fun deleteById(id: Long)

    fun findAll(pageable: Pageable): Page<EmployeeEntity>

    fun findAllByFirstName(pageable: Pageable, name: String): Page<EmployeeEntity>

    fun filter(employeeCriteria: EmployeeCriteria, pageable: Pageable): Page<EmployeeDto>
}