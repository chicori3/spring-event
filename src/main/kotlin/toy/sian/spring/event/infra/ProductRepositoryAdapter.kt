package toy.sian.spring.event.infra

import org.springframework.stereotype.Repository
import toy.sian.spring.event.domain.Product
import toy.sian.spring.event.domain.ProductRepository

@Repository
class ProductRepositoryAdapter(
    private val jpaProductRepository: JpaProductRepository,
): ProductRepository {
    override fun save(product: Product) {
        jpaProductRepository.save(product)
    }
}