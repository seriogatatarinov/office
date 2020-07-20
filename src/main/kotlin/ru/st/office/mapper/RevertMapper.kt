package ru.st.office.mapper

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import java.util.function.Supplier
import java.util.stream.Collectors

interface RevertMapper<SOURCE, TARGET> {

    fun revert(targ: TARGET, factory: Supplier<SOURCE>?): SOURCE

    fun revert(targ: TARGET): SOURCE

    fun revert(targets: MutableList<TARGET>?): MutableList<SOURCE>? {
        return if (targets == null) {
            mutableListOf<SOURCE>()
        } else targets.stream().map { targ: TARGET -> this.revert(targ) }.collect(Collectors.toList())
    }

    fun revert(targets: Set<TARGET>?): Set<SOURCE>? {
        return if (targets == null) {
            emptySet()
        } else targets.stream().map { targ: TARGET -> this.revert(targ) }.collect(Collectors.toSet())
    }

    fun revert(targets: Page<TARGET>?): Page<SOURCE>? {
        return if (targets != null) PageImpl(revert(targets.content)!!, targets.pageable, targets.totalElements) else Page.empty()
    }
}