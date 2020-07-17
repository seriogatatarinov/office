package ru.st.office.service

import ru.st.office.demo.entities.DepartmentEntity
import java.util.*

interface DepartmentService {

    fun save(department: DepartmentEntity): DepartmentEntity

    fun findById(id: Long): Optional<DepartmentEntity>

    fun deleteById(id: Long)

    fun findAll(): List<DepartmentEntity>
}