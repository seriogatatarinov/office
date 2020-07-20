package ru.st.office.filter

import ru.st.office.entity.DepartmentEntity
import java.time.LocalDateTime

data class DepartmentCriteria (val name: String = "",
                               val createdAt: LocalDateTime = LocalDateTime.now(),
                               val modifiedAt: LocalDateTime = LocalDateTime.now())