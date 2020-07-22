package ru.st.office.dto

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import javax.validation.constraints.NotNull

@ApiModel(description = "Employee")
data class EmployeeDto(@NotNull @ApiModelProperty("First name") var firstName: String = "",
                       @ApiModelProperty("Last name") var lastName: String? = "",
                       @ApiModelProperty("Department") var departmentId: Long = 0L) : BaseAuditDto()