package toy.sian.spring.event.common

import mu.KotlinLogging

abstract class AggregateRoot {
    @Transient
    private val _domainEvents: MutableList<DomainEvent> = mutableListOf()

    protected fun raise(event: DomainEvent) {
        log.debug("raised domain event. [type=${event::class.simpleName}]")
        _domainEvents.add(event)
    }

    fun occurredEvents(): List<DomainEvent> {
        val events = _domainEvents.toList()
        _domainEvents.clear()
        log.debug("return occurred events. [numberOfEvents=${events.size}]")
        return events
    }

    companion object {
        private val log = KotlinLogging.logger { }
    }
}
