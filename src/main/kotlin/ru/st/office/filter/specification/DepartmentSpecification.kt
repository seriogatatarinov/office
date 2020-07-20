package ru.st.office.filter.specification

import ru.st.office.entity.DepartmentEntity
import ru.st.office.filter.DepartmentCriteria
import java.util.*
import javax.persistence.criteria.*

class DepartmentSpecification(var departmentCriteria: DepartmentCriteria) : AbstractSpecification<DepartmentEntity>() {

    override fun addConditions(root: Root<DepartmentEntity>, criteriaBuilder: CriteriaBuilder?, predicate: Predicate?, criteriaQuery: CriteriaQuery<*>?): Predicate? {
        Optional.ofNullable(departmentCriteria.name).ifPresent{
            addLikeCondition(predicate!!, criteriaBuilder!!, it, root.get<String>("name"))
        }
        Optional.ofNullable(departmentCriteria.createdAt).ifPresent{
            addEqualCondition(predicate!!, criteriaBuilder!!, it, root.get<String>("createdAt"))
        }
        Optional.ofNullable(departmentCriteria.modifiedAt).ifPresent{
            addEqualCondition(predicate!!, criteriaBuilder!!, it, root.get<String>("modifiedAt"))
        }

        return predicate;
    }
}