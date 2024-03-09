package toy.sian.spring.event.user.domain

import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class UserActivityHistoryHandler(
    private val userActivityHistoryRepository: UserActivityHistoryRepository,
) {
    @Transactional
    fun handleSignIn(userId: Long): UserActivityHistory {
        return userActivityHistoryRepository.save(
            UserActivityHistory(
                userId = userId,
                type = UserActivityHistory.ActivityType.SIGN_IN,
            ),
        )
    }

    @Transactional
    fun handleSignOut(userId: Long): UserActivityHistory {
        return userActivityHistoryRepository.save(
            UserActivityHistory(
                userId = userId,
                type = UserActivityHistory.ActivityType.SIGN_OUT,
            ),
        )
    }
}
