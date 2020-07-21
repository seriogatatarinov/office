package ru.st.office.filter

import ru.st.office.entity.DepartmentEntity
import java.time.LocalDateTime

data class EmployeeCriteria(val firstName: String,
                            val lastName: String,
                            val department: DepartmentEntity,
                            val createdAt: LocalDateTime,
                            val modifiedAt: LocalDateTime)