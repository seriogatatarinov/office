package ru.st.office.dto

import io.swagger.annotations.ApiModelProperty
import java.time.LocalDateTime

open class BaseDto(@ApiModelProperty("Id") var id: Long = 0L,
                   @ApiModelProperty("Created date") var createdAt: LocalDateTime = LocalDateTime.now(),
                   @ApiModelProperty("Modified date") var modifiedAt: LocalDateTime = LocalDateTime.now())