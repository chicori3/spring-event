package toy.sian.spring.event.event

data class ProductCreated(
    val id: Long,
    val name: String,
    val price: Long,
)