package ru.st.office.dto

import ru.st.office.entity.DepartmentEntity
import java.time.LocalDateTime

data class EmployeeDto(var firstName: String = "",
                       var lastName: String = "",
                       var department: DepartmentEntity = DepartmentEntity(),
                       var createdAt: LocalDateTime = LocalDateTime.now(),
                       var modifiedAt: LocalDateTime = LocalDateTime.now()) {
}