package ru.st.office.controller

import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import ru.st.office.demo.entities.EmployeeEntity
import ru.st.office.service.EmployeeService

@RestController
@RequestMapping("/employees")
class EmployeeController(@Autowired val employeeService: EmployeeService) {

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    @ApiOperation("Get list of employees")
    fun findAll(@PageableDefault pageable: Pageable): Page<EmployeeEntity> = employeeService.findAll(pageable)

    @GetMapping("/{id}")
    @ApiOperation("Find employee by id")
    fun findEmployeeById(@PathVariable id: Long): EmployeeEntity = employeeService.findById(id).orElse(null)

    @PostMapping
    @ApiOperation("Save employee")
    fun saveEmployee(@RequestBody employeeEntity: EmployeeEntity) = employeeService.save(employeeEntity)

    @DeleteMapping("/{id}")
    @ApiOperation("Delete employee by id")
    fun deleteEmployeeById(@PathVariable id: Long) = employeeService.deleteById(id)

}