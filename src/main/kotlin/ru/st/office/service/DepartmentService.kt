package ru.st.office.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import ru.st.office.dto.DepartmentDto
import ru.st.office.filter.DepartmentCriteria
import java.util.*

interface DepartmentService {

    fun save(department: DepartmentDto): DepartmentDto

    fun findById(id: Long): Optional<DepartmentDto>

    fun deleteById(id: Long)

    fun findAll(pageable: Pageable): Page<DepartmentDto>

    fun findAllByName(pageable: Pageable, name: String): Page<DepartmentDto>

    fun filter(departmentCriteria: DepartmentCriteria, pageable: Pageable): Page<DepartmentDto>
}