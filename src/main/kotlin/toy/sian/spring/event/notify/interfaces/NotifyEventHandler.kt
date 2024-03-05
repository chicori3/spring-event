package toy.sian.spring.event.notify.interfaces

import mu.KotlinLogging
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import toy.sian.spring.event.user.domain.UserRegistered

@Component
class NotifyEventHandler {

    @EventListener(UserRegistered::class)
    fun handleUserRegistered(event: UserRegistered) {
        log.warn { "UserRegistered event received: $event" }
    }

    companion object {
        private val log = KotlinLogging.logger { }
    }
}
