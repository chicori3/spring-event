package toy.sian.spring.event.domain.exception

import toy.sian.spring.event.common.DomainException

class ProductIllegalArgumentException(
    msg: String = "Product argument is invalid"
): DomainException()