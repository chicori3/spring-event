package toy.sian.spring.event.user.domain

import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class UserSignInHandler(
    private val userFinder: UserFinder,
    private val tokenGenerator: TokenGenerator,
) {
    @Transactional
    fun signIn(email: String): String {
        userFinder.findByEmail(email)
            ?: throw UserNotFoundException()

        return tokenGenerator.generate()
    }
}
