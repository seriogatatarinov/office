package ru.st.office.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import ru.st.office.demo.entities.EmployeeEntity
import ru.st.office.demo.repositories.EmployeeRepository
import ru.st.office.service.EmployeeService
import java.util.*

@Service
class EmployeeServiceImpl(@Autowired val employeeRepository: EmployeeRepository) : EmployeeService {

    override fun save(employee: EmployeeEntity): EmployeeEntity = employeeRepository.save(employee)

    override fun findById(id: Long): Optional<EmployeeEntity> = employeeRepository.findById(id)

    override fun deleteById(id: Long) = employeeRepository.deleteById(id)

    override fun findAll(pageable: Pageable): Page<EmployeeEntity> = employeeRepository.findAll(pageable)

    override fun findAllByFirstName(pageable: Pageable, name: String): Page<EmployeeEntity> = employeeRepository.findAllByFirstName(pageable, name)
}