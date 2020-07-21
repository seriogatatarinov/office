package ru.st.office.dto

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import javax.validation.constraints.NotNull

@ApiModel(description = "Department")
data class DepartmentDto(@NotNull @ApiModelProperty("First name") var name: String = "") : BaseDto()