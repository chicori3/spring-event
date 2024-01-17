package toy.sian.spring.event.application

import org.springframework.stereotype.Service

@Service
class ProductManager(
    private val createProductProcessor: CreateProductProcessor,
) {

    fun createProduct(command: CreateProductProcessor.Command) {
        createProductProcessor.execute(command)
    }
}