package ru.st.office.demo.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.st.office.demo.entities.DepartmentEntity

@Repository
interface DepartmentRepository : JpaRepository<DepartmentEntity, Long> {

    fun findOneByName(name: String) : DepartmentEntity
}