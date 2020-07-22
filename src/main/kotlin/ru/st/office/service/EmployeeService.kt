package ru.st.office.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import ru.st.office.dto.EmployeeDto
import ru.st.office.filter.EmployeeCriteria

interface EmployeeService : BaseAuditService<EmployeeDto> {

    fun findAllByFirstName(pageable: Pageable, name: String): Page<EmployeeDto>

    fun filter(employeeCriteria: EmployeeCriteria, pageable: Pageable): Page<EmployeeDto>
}