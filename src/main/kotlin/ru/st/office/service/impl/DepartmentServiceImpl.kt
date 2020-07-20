package ru.st.office.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import ru.st.office.demo.entities.DepartmentEntity
import ru.st.office.demo.repositories.DepartmentRepository
import ru.st.office.service.DepartmentService
import java.util.*

@Service
class DepartmentServiceImpl(@Autowired val departmentRepository: DepartmentRepository) : DepartmentService {

    override fun save(department: DepartmentEntity): DepartmentEntity = departmentRepository.save(department)

    override fun findById(id: Long): Optional<DepartmentEntity> = departmentRepository.findById(id)

    override fun deleteById(id: Long) = departmentRepository.deleteById(id)

    override fun findAll(pageable: Pageable): Page<DepartmentEntity> = departmentRepository.findAll(pageable)

    override fun findAllByName(pageable: Pageable, name: String): Page<DepartmentEntity> = departmentRepository.findAllByName(pageable, name)
}