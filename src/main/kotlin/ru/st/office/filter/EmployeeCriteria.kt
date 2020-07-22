package ru.st.office.filter

import java.time.LocalDateTime

data class EmployeeCriteria(val firstName: String?,
                            val lastName: String?,
                            val departmentId: Long?,
                            val createdAt: LocalDateTime?,
                            val modifiedAt: LocalDateTime?)