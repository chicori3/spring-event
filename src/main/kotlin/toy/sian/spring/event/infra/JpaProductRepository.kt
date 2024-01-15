package toy.sian.spring.event.infra

import org.springframework.data.jpa.repository.JpaRepository
import toy.sian.spring.event.domain.Product

interface JpaProductRepository: JpaRepository<Product, Long> {
}