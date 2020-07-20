package ru.st.office.dto

import java.time.LocalDateTime

class DepartmentDto(var name: String = "",
                    var employees: MutableList<EmployeeDto> = mutableListOf<EmployeeDto>(),
                    var createdAt: LocalDateTime = LocalDateTime.now(),
                    var modifiedAt: LocalDateTime = LocalDateTime.now()) {
}