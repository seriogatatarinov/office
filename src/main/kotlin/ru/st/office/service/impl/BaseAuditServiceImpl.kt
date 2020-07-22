package ru.st.office.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.transaction.annotation.Transactional
import ru.st.office.dto.BaseAuditDto
import ru.st.office.entity.BaseAuditEntity
import ru.st.office.mapper.BiDirectMapper
import ru.st.office.repository.BaseAuditRepository
import ru.st.office.service.BaseAuditService
import java.util.*

open class BaseAuditServiceImpl<ENTITY : BaseAuditEntity, DTO : BaseAuditDto>: BaseAuditService<DTO> {

    @Autowired
    private lateinit var baseAuditRepository: BaseAuditRepository<ENTITY, Long>

    @Autowired
    private lateinit var biDirectMapper: BiDirectMapper<ENTITY, DTO>

    @Transactional
    override fun save(dto: DTO): DTO =
            biDirectMapper.convert(baseAuditRepository.save(biDirectMapper.revert(dto)))

    override fun findById(id: Long): Optional<DTO> =
            baseAuditRepository.findById(id).map(biDirectMapper::convert)

    @Transactional
    override fun deleteById(id: Long): Unit =
            baseAuditRepository.deleteById(id)

    override fun findAll(pageable: Pageable): Page<DTO> =
            biDirectMapper.convert(baseAuditRepository.findAll(pageable))!!
}