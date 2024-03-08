package toy.sian.spring.event.user.application

import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import toy.sian.spring.event.user.domain.UserRegister
import toy.sian.spring.event.user.domain.UserRegistered

@Service
class UserRegisterProcessor(
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
