package toy.sian.spring.event.user.domain

import toy.sian.spring.event.common.DomainEvent
import java.time.Instant

data class UserSignIn(
    val email: String,
    val loginAt: Instant,
) : DomainEvent()
