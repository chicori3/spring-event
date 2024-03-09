package toy.sian.spring.event.user.application

import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import toy.sian.spring.event.user.domain.User
import toy.sian.spring.event.user.domain.UserRegister
import toy.sian.spring.event.user.domain.UserRegistered

@Service
class UserRegisterProcessor(
    private val userRegister: UserRegister,
    private val eventPublisher: ApplicationEventPublisher,
) {
    @Transactional
    fun register(email: String, nickname: String): User {
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

        return registeredUser
    }
}
