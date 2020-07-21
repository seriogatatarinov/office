package ru.st.office.filter

import java.time.LocalDateTime

data class DepartmentCriteria(var name: String?,
                              var createdAt: LocalDateTime?,
                              var modifiedAt: LocalDateTime?)