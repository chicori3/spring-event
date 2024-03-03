package toy.sian.spring.event.user.domain

import toy.sian.spring.event.common.DomainEvent
import java.time.Instant

data class UserRegistered(
    val email: String,
    val nickname: String,
    val createdAt: Instant,
) : DomainEvent()
