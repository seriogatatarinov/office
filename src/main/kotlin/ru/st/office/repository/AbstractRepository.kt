package ru.st.office.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import ru.st.office.entity.BaseAuditEntity

interface AbstractRepository<T : BaseAuditEntity<*>?, ID> : JpaRepository<T, ID>, JpaSpecificationExecutor<T> {
}