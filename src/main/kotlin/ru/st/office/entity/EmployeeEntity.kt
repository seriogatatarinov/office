package ru.st.office.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "employee")
class EmployeeEntity(

        var firstName: String = "",

        var lastName: String? = "",

        @ManyToOne
        @JoinColumn(name = "department_id")
        @JsonManagedReference
        var department: DepartmentEntity = DepartmentEntity()
) : BaseAuditEntity()