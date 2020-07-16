package ru.st.office.demo.repositories

import org.springframework.data.jpa.repository.JpaRepository
import ru.st.office.demo.entities.EmployeeEntity

interface EmployeeRepository : JpaRepository<EmployeeEntity, Long>