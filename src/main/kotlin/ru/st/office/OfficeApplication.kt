package ru.st.office

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class OfficeApplication

fun main(args: Array<String>) {
    var getenv = System.getenv()
    print(getenv)
    runApplication<OfficeApplication>(*args)
}
