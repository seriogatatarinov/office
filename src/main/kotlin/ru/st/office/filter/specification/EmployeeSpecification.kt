package ru.st.office.filter.specification

import ru.st.office.entity.EmployeeEntity
import ru.st.office.filter.EmployeeCriteria
import java.util.*
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Predicate
import javax.persistence.criteria.Root

class EmployeeSpecification(var employeeCriteria: EmployeeCriteria) : AbstractSpecification<EmployeeEntity>() {

    override fun addConditions(root: Root<EmployeeEntity>, criteriaBuilder: CriteriaBuilder?, predicate: Predicate?, criteriaQuery: CriteriaQuery<*>?): Predicate? {
        Optional.ofNullable(employeeCriteria.firstName).ifPresent {
            addLikeCondition(predicate!!, criteriaBuilder!!, it, root.get<String>("firstName"))
        }
        Optional.ofNullable(employeeCriteria.lastName).ifPresent {
            addLikeCondition(predicate!!, criteriaBuilder!!, it, root.get<String>("lastName"))
        }
        Optional.ofNullable(employeeCriteria.createdAt).ifPresent {
            addEqualCondition(predicate!!, criteriaBuilder!!, it, root.get<String>("createdAt"))
        }
        Optional.ofNullable(employeeCriteria.modifiedAt).ifPresent {
            addEqualCondition(predicate!!, criteriaBuilder!!, it, root.get<String>("modifiedAt"))
        }
        return predicate
    }
}