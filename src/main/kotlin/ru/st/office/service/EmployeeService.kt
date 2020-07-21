package ru.st.office.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import ru.st.office.dto.EmployeeDto
import ru.st.office.filter.EmployeeCriteria
import java.util.*

interface EmployeeService {

    fun save(employee: EmployeeDto): EmployeeDto

    fun findById(id: Long): Optional<EmployeeDto>

    fun deleteById(id: Long)

    fun findAll(pageable: Pageable): Page<EmployeeDto>

    fun findAllByFirstName(pageable: Pageable, name: String): Page<EmployeeDto>

    fun filter(employeeCriteria: EmployeeCriteria, pageable: Pageable): Page<EmployeeDto>
}