package ru.st.office.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import ru.st.office.dto.DepartmentDto
import ru.st.office.entity.DepartmentEntity
import ru.st.office.filter.DepartmentCriteria
import ru.st.office.filter.specification.DepartmentSpecification
import ru.st.office.mapper.DepartmentMapper
import ru.st.office.repository.DepartmentRepository
import ru.st.office.service.DepartmentService

@Service
class DepartmentServiceImpl(@Autowired val departmentRepository: DepartmentRepository,
                            @Autowired val departmentMapper: DepartmentMapper) : BaseAuditServiceImpl<DepartmentEntity, DepartmentDto>(), DepartmentService {

    override fun findAllByName(pageable: Pageable, name: String): Page<DepartmentDto> =
            departmentMapper.convert(departmentRepository.findAllByName(pageable, name))!!

    override fun filter(departmentCriteria: DepartmentCriteria, pageable: Pageable): Page<DepartmentDto> =
            departmentMapper.convert(departmentRepository.findAll(DepartmentSpecification(departmentCriteria), pageable))!!
}