package toy.sian.spring.event.domain

interface ProductRepository {
    fun save(product: Product)
}