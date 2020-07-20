package ru.st.office.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import ru.st.office.demo.entities.DepartmentEntity
import java.util.*

interface DepartmentService {

    fun save(department: DepartmentEntity): DepartmentEntity

    fun findById(id: Long): Optional<DepartmentEntity>

    fun deleteById(id: Long)

    fun findAll(pageable: Pageable): Page<DepartmentEntity>

    fun findAllByName(pageable: Pageable, name: String): Page<DepartmentEntity>
}