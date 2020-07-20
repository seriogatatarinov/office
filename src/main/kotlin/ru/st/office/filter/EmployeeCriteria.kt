package ru.st.office.filter

import ru.st.office.entity.DepartmentEntity
import java.time.LocalDateTime

data class EmployeeCriteria(val firstName: String = "",
                            var lastName: String = "",
                            val department: DepartmentEntity = DepartmentEntity(),
                            val createdAt: LocalDateTime = LocalDateTime.now(),
                            val modifiedAt: LocalDateTime = LocalDateTime.now())