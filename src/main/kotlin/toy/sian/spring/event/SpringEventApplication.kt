package toy.sian.spring.event

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.scheduling.annotation.EnableAsync

@EnableJpaAuditing
@EnableAsync
@SpringBootApplication
class SpringEventApplication

fun main(args: Array<String>) {
    runApplication<SpringEventApplication>(*args)
}
