package ru.st.office.controller

import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.st.office.dto.EmployeeDto
import ru.st.office.filter.EmployeeCriteria
import ru.st.office.service.EmployeeService

@RestController
@RequestMapping("/employees")
class EmployeeController(@Autowired val employeeService: EmployeeService) {

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    @ApiOperation("Get list of employees")
    fun findAll(@PageableDefault pageable: Pageable): Page<EmployeeDto> =
            employeeService.findAll(pageable)

    @GetMapping("/{id}")
    @ApiOperation("Find employee by id")
    fun findEmployeeById(@PathVariable id: Long): ResponseEntity<EmployeeDto> =
            ResponseEntity.of(employeeService.findById(id))

    @PostMapping
    @ApiOperation("Save employee")
    fun saveEmployee(@RequestBody employeeDto: EmployeeDto) =
            ResponseEntity.ok(employeeService.save(employeeDto))

    @DeleteMapping("/{id}")
    @ApiOperation("Delete employee by id")
    fun deleteEmployeeById(@PathVariable id: Long): ResponseEntity<Unit> {
        employeeService.deleteById(id)
        return ResponseEntity.ok().build<Unit>()
    }


    @GetMapping("/filter")
    @ApiOperation("Filter employees")
    fun filter(@ModelAttribute employeeCriteria: EmployeeCriteria, @PageableDefault pageable: Pageable) =
            employeeService.filter(employeeCriteria, pageable)

}