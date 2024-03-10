package toy.sian.spring.event.history.application

import mu.KotlinLogging
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import toy.sian.spring.event.history.domain.UserActivityHistory
import toy.sian.spring.event.history.domain.UserActivityHistoryHandler
import toy.sian.spring.event.user.domain.UserFinder
import toy.sian.spring.event.user.domain.UserNotFoundException

@Service
class UserActivityHistoryService(
    private val userActivityHistoryHandler: UserActivityHistoryHandler,
    private val userFinder: UserFinder,
) {
    @Transactional
    fun handleSignIn(userId: Long): UserActivityHistory {
        userFinder.findById(userId) ?: throw UserNotFoundException()
        return userActivityHistoryHandler.handleSignIn(userId)
    }

    @Transactional
    fun handleSignOut(userId: Long): UserActivityHistory {
        userFinder.findById(userId) ?: throw UserNotFoundException()
        return userActivityHistoryHandler.handleSignOut(userId)
    }

    companion object {
        private val log = KotlinLogging.logger { }
    }
}
