package toy.sian.spring.event.user.application

import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import toy.sian.spring.event.user.domain.UserSignIn
import toy.sian.spring.event.user.domain.UserSignedIn
import toy.sian.spring.event.user.domain.UserSignInHandler
import java.time.Instant

@Service
class UserSignInProcessor(
    private val userSignInHandler: UserSignInHandler,
    private val eventPublisher: ApplicationEventPublisher,
) {
    fun signIn(email: String): UserSignIn {
        val userSignIn = userSignInHandler.signIn(email)

        eventPublisher.publishEvent(
            UserSignedIn(
                userId = userSignIn.userId,
                email = userSignIn.email,
                loginAt = Instant.now(),
            ),
        )

        return userSignIn
    }
}
