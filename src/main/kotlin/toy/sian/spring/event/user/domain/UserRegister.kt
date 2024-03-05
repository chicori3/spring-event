package toy.sian.spring.event.user.domain

import org.springframework.stereotype.Component

@Component
class UserRegister(
    private val userRepository: UserRepository,
) {
    fun register(email: String, nickname: String): User {
        val user = User(
            email = email,
            nickname = nickname,
        )
        userRepository.save(user)

        return user
    }
}
