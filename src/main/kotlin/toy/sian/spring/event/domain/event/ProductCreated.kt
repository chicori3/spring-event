package toy.sian.spring.event.domain.event

data class ProductCreated(
    val id: Long,
    val name: String,
    val price: Long,
)