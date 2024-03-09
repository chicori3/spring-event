package toy.sian.spring.event.user.application

import org.springframework.stereotype.Service
import toy.sian.spring.event.user.domain.UserActivityHistory
import toy.sian.spring.event.user.domain.UserActivityHistoryHandler
import toy.sian.spring.event.user.domain.UserFinder
import toy.sian.spring.event.user.domain.UserNotFoundException

@Service
class UserActivityHistoryService(
    private val userActivityHistoryHandler: UserActivityHistoryHandler,
    private val userFinder: UserFinder,
) {
    fun handleSignIn(userId: Long): UserActivityHistory {
        userFinder.findById(userId) ?: throw UserNotFoundException()
        return userActivityHistoryHandler.handleSignIn(userId)
    }

    fun handleSignOut(userId: Long): UserActivityHistory {
        userFinder.findById(userId) ?: throw UserNotFoundException()
        return userActivityHistoryHandler.handleSignOut(userId)
    }
}
