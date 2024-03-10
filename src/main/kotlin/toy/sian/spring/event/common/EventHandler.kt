package toy.sian.spring.event.common

import mu.KotlinLogging
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import org.springframework.transaction.event.TransactionalEventListener
import toy.sian.spring.event.history.application.UserActivityHistoryService
import toy.sian.spring.event.user.domain.UserRegistered
import toy.sian.spring.event.user.domain.UserSignedIn

@Component
class EventHandler(
    private val userActivityHistoryService: UserActivityHistoryService,
) {
    @EventListener(UserRegistered::class)
    fun notifyUserRegistered(event: UserRegistered) {
        log.info { "UserRegistered event received" }
    }

    @EventListener(UserSignedIn::class)
    fun handleUserLoggedIn(event: UserSignedIn) {
        log.info { "UserLoggedIn event received" }
        userActivityHistoryService.handleSignIn(event.userId)
    }

    @TransactionalEventListener(UserSignedIn::class)
    fun handleUserLoggedInTx(event: UserSignedIn) {
        log.info { "UserLoggedIn event received in transaction" }
        userActivityHistoryService.handleSignIn(event.userId)
    }

    @Async
    @EventListener(UserSignedIn::class)
    fun handleUserLoggedInAsync(event: UserSignedIn) {
        log.info { "UserLoggedIn event received asynchronously" }
        userActivityHistoryService.handleSignIn(event.userId)
    }

    @Async
    @TransactionalEventListener(UserSignedIn::class)
    fun handleUserLoggedInTxAsync(event: UserSignedIn) {
        log.info { "UserLoggedIn event received asynchronously in transaction" }
        userActivityHistoryService.handleSignIn(event.userId)
    }

    companion object {
        private val log = KotlinLogging.logger { }
    }
}
