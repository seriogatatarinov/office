package ru.st.office.service.impl

import org.hibernate.Session
import org.hibernate.query.Query
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.st.office.demo.entities.EmployeeEntity
import ru.st.office.demo.repositories.EmployeeRepository
import ru.st.office.service.EmployeeService
import java.util.*
import javax.persistence.EntityManager

@Service
class EmployeeServiceImpl(@Autowired val employeeRepository: EmployeeRepository, @Autowired val entityManager: EntityManager) : EmployeeService {

    override fun save(employee: EmployeeEntity): EmployeeEntity = employeeRepository.save(employee)

    override fun findById(id: Long): Optional<EmployeeEntity> = employeeRepository.findById(id)

    override fun deleteById(id: Long) {
        employeeRepository.deleteById(id)
    }

    override fun findAll(): List<EmployeeEntity> {
        val currentSession: Session = entityManager.unwrap(Session::class.java)
        val query: Query<EmployeeEntity> = currentSession.createQuery("from EmployeeEntity", EmployeeEntity::class.java)
        val resultList: MutableList<EmployeeEntity> = query.resultList
        return resultList
    }
}