package ru.st.office.controller

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
    fun employees(@PageableDefault pageable: Pageable): Page<EmployeeEntity> = employeeService.findAll(pageable)

    @GetMapping("/{id}")
    fun getEmployeeById(@PathVariable id: Long): EmployeeEntity = employeeService.findById(id).orElse(null)

    @PostMapping
    fun saveEmployee(@RequestBody employeeEntity: EmployeeEntity) = employeeService.save(employeeEntity)

    @DeleteMapping("/{id}")
    fun deleteEmployeeById(@PathVariable id: Long) = employeeService.deleteById(id)

}