package toy.sian.spring.event.user.application

import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import toy.sian.spring.event.user.domain.UserSignIn
import toy.sian.spring.event.user.domain.UserSignInHandler
import java.time.Instant

@Service
class UserSignInProcessor(
    private val userSignInHandler: UserSignInHandler,
    private val eventPublisher: ApplicationEventPublisher,
) {
    fun signIn(email: String): String {
        val token = userSignInHandler.signIn(email)

        eventPublisher.publishEvent(
            UserSignIn(
                email = email,
                loginAt = Instant.now(),
            ),
        )

        return token
    }
}
