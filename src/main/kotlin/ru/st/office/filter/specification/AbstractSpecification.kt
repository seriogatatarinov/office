package ru.st.office.filter.specification

import org.springframework.data.jpa.domain.Specification
import org.springframework.util.CollectionUtils
import java.time.Instant
import javax.persistence.criteria.*

abstract class AbstractSpecification<T> : Specification<T> {

    override fun toPredicate(root: Root<T>, criteriaQuery: CriteriaQuery<*>, criteriaBuilder: CriteriaBuilder): Predicate? {
        criteriaQuery.distinct(true)
        return addConditions(root, criteriaBuilder, criteriaBuilder.conjunction(), criteriaQuery)
    }

    protected abstract fun addConditions(root: Root<T>, criteriaBuilder: CriteriaBuilder?, predicate: Predicate?, criteriaQuery: CriteriaQuery<*>?): Predicate?
    protected fun addLikeCondition(predicate: Predicate, cb: CriteriaBuilder, value: String?, expression: Expression<String?>?) {
        if (value != null) {
            predicate.expressions.add(cb.like(cb.upper(cb.trim(expression)), "%" + value.trim { it <= ' ' }.toUpperCase() + "%"))
        }
    }

    protected fun addEqualCondition(predicate: Predicate, criteriaBuilder: CriteriaBuilder, value: Any?, expression: Expression<*>?) {
        if (value != null) {
            predicate.expressions.add(criteriaBuilder.equal(expression, value))
        }
    }

    protected fun addNotEqualCondition(predicate: Predicate, criteriaBuilder: CriteriaBuilder, value: Any?, expression: Expression<*>?) {
        if (value != null) {
            predicate.expressions.add(criteriaBuilder.notEqual(expression, value))
        }
    }

    protected fun addNotNullCondition(predicate: Predicate, criteriaBuilder: CriteriaBuilder, expression: Expression<*>?) {
        predicate.expressions.add(criteriaBuilder.isNotNull(expression))
    }

    protected fun addNullCondition(predicate: Predicate, criteriaBuilder: CriteriaBuilder, expression: Expression<*>?) {
        predicate.expressions.add(criteriaBuilder.isNull(expression))
    }

    protected fun addInCondition(predicate: Predicate, list: List<*>?, expression: Expression<*>) {
        if (!CollectionUtils.isEmpty(list)) {
            predicate.expressions.add(expression.`in`(list))
        }
    }

    protected fun addNotInCondition(predicate: Predicate, list: List<*>?, expression: Expression<*>) {
        if (!CollectionUtils.isEmpty(list)) {
            predicate.expressions.add(expression.`in`(list).not())
        }
    }

    protected fun addBeforeNowCondition(predicate: Predicate, criteriaBuilder: CriteriaBuilder, timestamp: Expression<Instant>?) {
        predicate.expressions.add(criteriaBuilder.lessThan(timestamp, Instant.now()))
    }

    protected fun addBeforeTimeCondition(predicate: Predicate, criteriaBuilder: CriteriaBuilder, value: Instant?, timestamp: Expression<Instant>?) {
        if (value != null) {
            predicate.expressions.add(criteriaBuilder.lessThan(timestamp, value))
        }
    }
}