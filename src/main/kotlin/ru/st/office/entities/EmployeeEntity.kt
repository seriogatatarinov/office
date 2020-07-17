package ru.st.office.demo.entities

import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "employee")
class EmployeeEntity(

        val firstName: String,

        var lastName: String? = null,

        @ManyToOne
        @JoinColumn(name = "department_id")
        @JsonManagedReference
        val department: DepartmentEntity
) : BaseAuditEntity<Long>()