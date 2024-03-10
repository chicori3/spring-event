package toy.sian.spring.event.history.domain

import mu.KotlinLogging
import org.springframework.stereotype.Component

@Component
class UserActivityHistoryHandler(
    private val userActivityHistoryRepository: UserActivityHistoryRepository,
) {
    fun handleSignIn(userId: Long): UserActivityHistory {
        log.info { "Handle Sign In processed by ${Thread.currentThread().name}" }

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

    companion object {
        private val log = KotlinLogging.logger { }
    }
}
