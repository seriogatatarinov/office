package ru.st.office.demo.repositories

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.st.office.demo.entities.EmployeeEntity

@Repository
interface EmployeeRepository : JpaRepository<EmployeeEntity, Long> {
    fun findAllByFirstName(pageable: Pageable, name: String): Page<EmployeeEntity>
}