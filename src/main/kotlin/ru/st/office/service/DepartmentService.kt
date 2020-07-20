package ru.st.office.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import ru.st.office.entity.DepartmentEntity
import ru.st.office.dto.DepartmentDto
import ru.st.office.filter.DepartmentCriteria
import java.util.*

interface DepartmentService {

    fun save(department: DepartmentEntity): DepartmentEntity

    fun findById(id: Long): Optional<DepartmentEntity>

    fun deleteById(id: Long)

    fun findAll(pageable: Pageable): Page<DepartmentEntity>

    fun findAllByName(pageable: Pageable, name: String): Page<DepartmentEntity>

    fun filter(departmentCriteria: DepartmentCriteria, pageable: Pageable): Page<DepartmentDto>
}