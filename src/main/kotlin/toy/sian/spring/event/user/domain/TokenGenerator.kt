package toy.sian.spring.event.user.domain

import org.springframework.stereotype.Component

@Component
class TokenGenerator {
    private val tokenLength = 64
    private val charSet = ('a'..'z') + ('A'..'Z') + ('0'..'9')

    fun generate(): String {
        return (1..tokenLength)
            .map { charSet.random() }
            .joinToString("")
    }
}
