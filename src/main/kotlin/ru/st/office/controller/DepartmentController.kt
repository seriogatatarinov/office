package ru.st.office.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import ru.st.office.demo.entities.DepartmentEntity
import ru.st.office.service.DepartmentService

@RestController
@RequestMapping("/departments")
class DepartmentController(@Autowired val departmentService: DepartmentService) {

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun departments(@PageableDefault pageable: Pageable): Page<DepartmentEntity> = departmentService.findAll(pageable)

    @GetMapping("/{id}")
    fun getDepartmentById(@PathVariable id: Long): DepartmentEntity = departmentService.findById(id).orElse(null)

    @PostMapping
    fun saveDepartment(@RequestBody departmentEntity: DepartmentEntity) = departmentService.save(departmentEntity)

    @DeleteMapping("/{id}")
    fun deleteDepartmentById(@PathVariable id: Long) = departmentService.deleteById(id)

}