package toy.sian.spring.event.user.domain

import toy.sian.spring.event.common.DomainEvent
import java.time.Instant

data class UserLoggedIn(
    val userId: Long,
    val email: String,
    val loginAt: Instant,
) : DomainEvent()
