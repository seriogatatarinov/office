package ru.st.office.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.transaction.annotation.Transactional
import ru.st.office.dto.BaseAuditDto
import java.util.*

interface BaseAuditService<DTO: BaseAuditDto> {

    @Transactional
    fun save(dto: DTO): DTO

    fun findById(id: Long): Optional<DTO>

    @Transactional
    fun deleteById(id: Long)

    fun findAll(pageable: Pageable): Page<DTO>

}