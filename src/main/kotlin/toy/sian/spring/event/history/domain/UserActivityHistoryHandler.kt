package toy.sian.spring.event.history.domain

import org.springframework.stereotype.Component

@Component
class UserActivityHistoryHandler(
    private val userActivityHistoryRepository: UserActivityHistoryRepository,
) {
    fun handleSignIn(userId: Long): UserActivityHistory {
        return userActivityHistoryRepository.save(
            UserActivityHistory(
                userId = userId,
                type = UserActivityHistory.ActivityType.SIGN_IN,
            ),
        )
    }

    fun handleSignOut(userId: Long): UserActivityHistory {
        return userActivityHistoryRepository.save(
            UserActivityHistory(
                userId = userId,
                type = UserActivityHistory.ActivityType.SIGN_OUT,
            ),
        )
    }
}
