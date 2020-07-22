package ru.st.office.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import ru.st.office.dto.DepartmentDto
import ru.st.office.filter.DepartmentCriteria

interface DepartmentService: BaseAuditService<DepartmentDto> {

    fun findAllByName(pageable: Pageable, name: String): Page<DepartmentDto>

    fun filter(departmentCriteria: DepartmentCriteria, pageable: Pageable): Page<DepartmentDto>
}