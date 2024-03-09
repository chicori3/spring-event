package toy.sian.spring.event.user.domain

import toy.sian.spring.event.common.DomainException

class UserNotFoundException(
    message: String = "User not found",
) : DomainException(message)
