package toy.sian.spring.event.application

import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import toy.sian.spring.event.domain.Product
import toy.sian.spring.event.domain.ProductRepository
import toy.sian.spring.event.domain.exception.ProductIllegalArgumentException
import toy.sian.spring.event.event.ProductCreated

@Service
class CreateProductProcessor(
    private val productRepository: ProductRepository,
    private val eventPublisher: ApplicationEventPublisher,
) {
    @Transactional
    fun execute(command: Command) {
        verify(command)
        val product = Product(
            name = command.name,
            price = command.price,
            quantity = command.quantity,
        )

        productRepository.save(product)

        eventPublisher.publishEvent(
            ProductCreated(
                id = product.id,
                name = product.name,
                price = product.price,
            )
        )
    }

    private fun verify(command: Command) {
        if (command.name.isBlank()) throw ProductIllegalArgumentException("Product name is blank")
        if (command.price < 0) throw ProductIllegalArgumentException("Product price is negative")
        if (command.quantity < 0) throw ProductIllegalArgumentException("Product quantity is negative")
    }

    data class Command(
        val name: String,
        val price: Long,
        val quantity: Long,
    )
}