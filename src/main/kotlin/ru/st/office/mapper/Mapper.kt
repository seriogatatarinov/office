package ru.st.office.mapper

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import java.util.function.Supplier
import java.util.stream.Collectors

interface Mapper<SOURCE, TARGET> {

    fun convert(src: SOURCE, factory: Supplier<TARGET>?): TARGET

    fun convert(src: SOURCE): TARGET

    fun convert(sources: MutableList<SOURCE>?): MutableList<TARGET>? {
        return if (sources == null) {
            mutableListOf<TARGET>()
        } else sources.stream().map { src: SOURCE -> this.convert(src) }.collect(Collectors.toList())
    }

    fun convert(sources: Set<SOURCE>?): Set<TARGET>? {
        return if (sources == null) {
            emptySet()
        } else sources.stream().map { src: SOURCE -> this.convert(src) }.collect(Collectors.toSet())
    }

    fun convert(sources: Page<SOURCE>?): Page<TARGET>? {
        return if (sources != null) PageImpl(convert(sources.content)!!, sources.pageable, sources.totalElements) else Page.empty()
    }

}