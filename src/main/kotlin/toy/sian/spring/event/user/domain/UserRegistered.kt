package toy.sian.spring.event.user.domain

import toy.sian.spring.event.common.DomainEvent

data class UserRegistered(
    val userId: Long,
    val email: String,
    val nickname: String,
) : DomainEvent()
