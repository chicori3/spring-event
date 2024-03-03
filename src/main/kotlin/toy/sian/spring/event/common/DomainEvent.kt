package toy.sian.spring.event.common

import java.time.Instant

abstract class DomainEvent(
    val occurredOn: Instant = Instant.now(),
)
