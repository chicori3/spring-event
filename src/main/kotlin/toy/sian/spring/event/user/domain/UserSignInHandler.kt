package toy.sian.spring.event.user.domain

import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class UserSignInHandler(
    private val userFinder: UserFinder,
    private val tokenGenerator: TokenGenerator,
) {
    @Transactional
    fun signIn(email: String): UserSignIn {
        val user = userFinder.findByEmail(email)
            ?: throw UserNotFoundException()
        val token = tokenGenerator.generate()

        return UserSignIn(
            userId = user.id,
            email = user.email,
            token = token,
        )
    }
}
