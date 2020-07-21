package ru.st.office.mapper

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import ru.st.office.dto.EmployeeDto
import ru.st.office.entity.EmployeeEntity
import ru.st.office.repository.DepartmentRepository
import java.util.function.Supplier

@Component
class EmployeeMapper(@Autowired val departmentMapper: DepartmentMapper,
                     @Autowired val departmentRepository: DepartmentRepository) : BiDirectMapper<EmployeeEntity, EmployeeDto> {

    override fun convert(src: EmployeeEntity, factory: Supplier<EmployeeDto>?): EmployeeDto {
        val employeeDto: EmployeeDto = factory!!.get()
        employeeDto.id = src.id!!
        employeeDto.firstName = src.firstName
        employeeDto.departmentId = departmentMapper.convert(src.department).id
        employeeDto.lastName = src.lastName
        employeeDto.createdAt = src.createdAt
        employeeDto.modifiedAt = src.modifiedAt
        return employeeDto
    }

    override fun convert(src: EmployeeEntity): EmployeeDto {
        return convert(src, Supplier { EmployeeDto() })
    }

    override fun revert(targ: EmployeeDto, factory: Supplier<EmployeeEntity>?): EmployeeEntity {
        val employeeEntity: EmployeeEntity = factory!!.get()
        employeeEntity.id = targ.id
        employeeEntity.firstName = targ.firstName
        employeeEntity.department = departmentRepository.findById(targ.departmentId)
                .orElseThrow { RuntimeException("Failed to resolve entity Department with id $targ.departmentId") }
        employeeEntity.lastName = targ.lastName
        employeeEntity.createdAt = targ.createdAt
        employeeEntity.modifiedAt = targ.modifiedAt
        return employeeEntity
    }

    override fun revert(targ: EmployeeDto): EmployeeEntity = revert(targ, Supplier { EmployeeEntity() })
}