package toy.sian.spring.event.common

import java.lang.RuntimeException

open class DomainException : RuntimeException {
    constructor() : super()
    constructor(message: String) : super(message)
    constructor(message: String, cause: Throwable) : super(message, cause)
}