package ru.st.office.mapper

import org.springframework.stereotype.Component
import ru.st.office.entity.EmployeeEntity
import ru.st.office.dto.EmployeeDto
import java.util.function.Supplier

@Component
class EmployeeMapper: BiDirectMapper<EmployeeEntity, EmployeeDto> {

    override fun convert(src: EmployeeEntity, factory: Supplier<EmployeeDto>?): EmployeeDto {
        val employeeDto: EmployeeDto = factory!!.get()
        employeeDto.firstName = src.firstName
        employeeDto.department = src.department
        employeeDto.lastName = src.lastName!!
        employeeDto.createdAt = src.createdAt
        employeeDto.modifiedAt = src.modifiedAt
        return employeeDto
    }

    override fun convert(src: EmployeeEntity): EmployeeDto = convert(src, Supplier { EmployeeDto() })

    override fun revert(targ: EmployeeDto, factory: Supplier<EmployeeEntity>?): EmployeeEntity {
        val employeeEntity: EmployeeEntity = factory!!.get()
        employeeEntity.firstName = targ.firstName
        employeeEntity.department = targ.department
        employeeEntity.lastName = targ.lastName
        employeeEntity.createdAt = targ.createdAt
        employeeEntity.modifiedAt = targ.modifiedAt
        return employeeEntity
    }

    override fun revert(targ: EmployeeDto): EmployeeEntity = revert(targ, Supplier{ EmployeeEntity() })
}