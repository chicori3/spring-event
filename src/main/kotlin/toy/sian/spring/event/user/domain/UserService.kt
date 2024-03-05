package toy.sian.spring.event.user.domain

import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRegister: UserRegister,

    private val eventPublisher: ApplicationEventPublisher,
) {
    fun register(email: String, nickname: String) {
        val registeredUser = userRegister.register(
            email = email,
            nickname = nickname,
        )

        eventPublisher.publishEvent(
            UserRegistered(
                userId = registeredUser.id,
                email = registeredUser.email,
                nickname = registeredUser.nickname,
            ),
        )
    }
}
