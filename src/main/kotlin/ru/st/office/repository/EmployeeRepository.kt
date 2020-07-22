package ru.st.office.demo.repository

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository
import ru.st.office.entity.EmployeeEntity
import ru.st.office.repository.BaseAuditRepository

@Repository
interface EmployeeRepository : BaseAuditRepository<EmployeeEntity, Long> {
    fun findAllByFirstName(pageable: Pageable, name: String): Page<EmployeeEntity>
}