package ru.st.office.controller

import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.st.office.dto.DepartmentDto
import ru.st.office.filter.DepartmentCriteria
import ru.st.office.service.DepartmentService

@RestController
@RequestMapping("/departments")
class DepartmentController(@Autowired val departmentService: DepartmentService) {

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    @ApiOperation("Get list of departments")
    fun findAll(@PageableDefault pageable: Pageable): Page<DepartmentDto> =
            departmentService.findAll(pageable)

    @GetMapping("/{id}")
    @ApiOperation("Find department by id")
    fun findDepartmentById(@PathVariable id: Long): ResponseEntity<DepartmentDto> =
            ResponseEntity.of(departmentService.findById(id))

    @PostMapping
    @ApiOperation("Save department")
    fun saveDepartment(@RequestBody departmentEntity: DepartmentDto) =
            ResponseEntity.ok(departmentService.save(departmentEntity))

    @DeleteMapping("/{id}")
    @ApiOperation("Delete department by id")
    fun deleteDepartmentById(@PathVariable id: Long): ResponseEntity<Unit> {
        departmentService.deleteById(id)
        return ResponseEntity.ok().build<Unit>()
    }

    @GetMapping("/filter")
    @ApiOperation("Filter departments")
    fun filter(departmentCriteria: DepartmentCriteria, pageable: Pageable) =
            departmentService.filter(departmentCriteria, pageable)

}