package ru.st.office.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import ru.st.office.demo.repository.EmployeeRepository
import ru.st.office.dto.EmployeeDto
import ru.st.office.filter.EmployeeCriteria
import ru.st.office.filter.specification.EmployeeSpecification
import ru.st.office.mapper.EmployeeMapper
import ru.st.office.service.EmployeeService
import java.util.*

@Service
class EmployeeServiceImpl(@Autowired val employeeRepository: EmployeeRepository, @Autowired val employeeMapper: EmployeeMapper) : EmployeeService {

    override fun save(employee: EmployeeDto): EmployeeDto =
            employeeMapper.convert(employeeRepository.save(employeeMapper.revert(employee)))

    override fun findById(id: Long): Optional<EmployeeDto> =
            employeeRepository.findById(id).map(employeeMapper::convert)

    override fun deleteById(id: Long) =
            employeeRepository.deleteById(id)

    override fun findAll(pageable: Pageable): Page<EmployeeDto> =
            employeeMapper.convert(employeeRepository.findAll(pageable))!!

    override fun findAllByFirstName(pageable: Pageable, name: String): Page<EmployeeDto> =
            employeeMapper.convert(employeeRepository.findAllByFirstName(pageable, name))!!

    override fun filter(employeeCriteria: EmployeeCriteria, pageable: Pageable): Page<EmployeeDto> =
            employeeMapper.convert(employeeRepository.findAll(EmployeeSpecification(employeeCriteria), pageable))!!
}