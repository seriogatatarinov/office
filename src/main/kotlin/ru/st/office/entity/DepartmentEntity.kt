package ru.st.office.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
@Table(name = "department")
class DepartmentEntity(

        var name: String = "",

        @OneToMany(
                mappedBy = "department",
                fetch = FetchType.LAZY,
                orphanRemoval = true,
                cascade = [CascadeType.ALL]
        )
        @JsonBackReference
        var employees: MutableList<EmployeeEntity> = mutableListOf()
) : BaseAuditEntity<Long>() {

    fun addEmployee(block: DepartmentEntity.() -> EmployeeEntity) {
        employees.add(block())
    }

    fun setEmployees(block: DepartmentEntity.() -> MutableSet<EmployeeEntity>) {
        employees.clear()
        employees.addAll(block())
    }
}