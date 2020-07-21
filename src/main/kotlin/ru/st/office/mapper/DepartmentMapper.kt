package ru.st.office.mapper

import org.springframework.stereotype.Component
import ru.st.office.dto.DepartmentDto
import ru.st.office.entity.DepartmentEntity
import java.util.function.Supplier

@Component
class DepartmentMapper : BiDirectMapper<DepartmentEntity, DepartmentDto> {

    override fun convert(src: DepartmentEntity, factory: Supplier<DepartmentDto>?): DepartmentDto {
        val departmentDto: DepartmentDto = factory!!.get()
        departmentDto.id = src.id!!
        departmentDto.name = src.name
        departmentDto.createdAt = src.createdAt
        departmentDto.modifiedAt = src.modifiedAt
        return departmentDto
    }

    override fun convert(src: DepartmentEntity): DepartmentDto = convert(src, Supplier { DepartmentDto() })

    override fun revert(targ: DepartmentDto, factory: Supplier<DepartmentEntity>?): DepartmentEntity {
        val departmentEntity: DepartmentEntity = factory!!.get()
        departmentEntity.id = targ.id
        departmentEntity.name = targ.name
        departmentEntity.createdAt = targ.createdAt
        departmentEntity.modifiedAt = targ.modifiedAt
        return departmentEntity
    }

    override fun revert(targ: DepartmentDto): DepartmentEntity = revert(targ, Supplier { DepartmentEntity() })
}