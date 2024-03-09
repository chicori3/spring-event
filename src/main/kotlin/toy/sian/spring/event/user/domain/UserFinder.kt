package toy.sian.spring.event.user.domain

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserFinder(
    private val userRepository: UserRepository,
) {
    fun findById(userId: Long): User? {
        return userRepository.findByIdOrNull(userId)
    }
}
