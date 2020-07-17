package ru.st.office

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class OfficeApplication

fun main(args: Array<String>) {
    runApplication<OfficeApplication>(*args)
}
