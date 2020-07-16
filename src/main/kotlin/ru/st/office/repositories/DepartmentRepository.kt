package ru.st.office.demo.repositories

import org.springframework.data.jpa.repository.JpaRepository
import ru.st.office.demo.entities.DepartmentEntity

interface DepartmentRepository : JpaRepository<DepartmentEntity, Long> {

    fun findOneByName(name: String) : DepartmentEntity
}