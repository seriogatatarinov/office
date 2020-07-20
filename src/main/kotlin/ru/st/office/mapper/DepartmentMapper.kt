package ru.st.office.mapper

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import ru.st.office.entity.DepartmentEntity
import ru.st.office.dto.DepartmentDto
import java.util.function.Supplier

@Component
class DepartmentMapper(@Autowired private val employeeMapper: EmployeeMapper): BiDirectMapper<DepartmentEntity, DepartmentDto> {

    override fun convert(src: DepartmentEntity, factory: Supplier<DepartmentDto>?): DepartmentDto {
        val departmentDto: DepartmentDto = factory!!.get()
        departmentDto.employees = employeeMapper.convert(src.employees)!!
        departmentDto.name = src.name
        departmentDto.createdAt = src.createdAt
        departmentDto.modifiedAt = src.modifiedAt
        return departmentDto
    }

    override fun convert(src: DepartmentEntity): DepartmentDto = convert(src, Supplier { DepartmentDto() })

    override fun revert(targ: DepartmentDto, factory: Supplier<DepartmentEntity>?): DepartmentEntity {
        val departmentEntity: DepartmentEntity = factory!!.get()
        departmentEntity.employees = employeeMapper.revert(targ.employees)!!
        departmentEntity.name = targ.name
        departmentEntity.createdAt = targ.createdAt
        departmentEntity.modifiedAt = targ.modifiedAt
        return departmentEntity
    }

    override fun revert(targ: DepartmentDto): DepartmentEntity = revert(targ, Supplier{ DepartmentEntity() })
}