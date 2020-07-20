package ru.st.office.repository

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository
import ru.st.office.entity.DepartmentEntity

@Repository
interface DepartmentRepository : AbstractRepository<DepartmentEntity, Long> {

    fun findOneByName(name: String): DepartmentEntity

    fun findAllByName(pageable: Pageable, name: String): Page<DepartmentEntity>
}