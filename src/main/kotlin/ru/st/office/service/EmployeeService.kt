package ru.st.office.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import ru.st.office.demo.entities.EmployeeEntity
import java.util.*

interface EmployeeService {

    fun save(employee: EmployeeEntity): EmployeeEntity

    fun findById(id: Long): Optional<EmployeeEntity>

    fun deleteById(id: Long)

    fun findAll(pageable: Pageable): Page<EmployeeEntity>

    fun findAllByFirstName(pageable: Pageable, name: String): Page<EmployeeEntity>
}