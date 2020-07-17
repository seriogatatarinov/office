package ru.st.office.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import ru.st.office.demo.entities.DepartmentEntity
import ru.st.office.service.DepartmentService

@RestController
@RequestMapping("/departments")
class DepartmentController(@Autowired val departmentService: DepartmentService) {

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun departments(): List<DepartmentEntity> = departmentService.findAll()

    @GetMapping("/{id}")
    fun getDepartmentById(@PathVariable id: Long): DepartmentEntity = departmentService.findById(id).orElse(null)

    @PostMapping
    fun saveDepartment(@RequestBody departmentEntity: DepartmentEntity) = departmentService.save(departmentEntity)

    @DeleteMapping("/{id}")
    fun deleteDepartmentById(@PathVariable id: Long) = departmentService.deleteById(id)

}