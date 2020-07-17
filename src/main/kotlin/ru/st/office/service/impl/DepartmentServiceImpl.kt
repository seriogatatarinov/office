package ru.st.office.service.impl

import org.hibernate.Session
import org.hibernate.query.Query
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.st.office.demo.entities.DepartmentEntity
import ru.st.office.demo.repositories.DepartmentRepository
import ru.st.office.service.DepartmentService
import java.util.*
import javax.persistence.EntityManager

@Service
class DepartmentServiceImpl(@Autowired val departmentRepository: DepartmentRepository, @Autowired val entityManager: EntityManager): DepartmentService {

    override fun save(department: DepartmentEntity): DepartmentEntity = departmentRepository.save(department)

    override fun findById(id: Long): Optional<DepartmentEntity> = departmentRepository.findById(id)

    override fun deleteById(id: Long) {
        departmentRepository.deleteById(id)
    }

    override fun findAll(): List<DepartmentEntity> {
        val currentSession: Session = entityManager.unwrap(Session::class.java)
        val query: Query<DepartmentEntity> = currentSession.createQuery("from DepartmentEntity", DepartmentEntity::class.java)
        val resultList: MutableList<DepartmentEntity> = query.resultList
        return resultList
    }
}