package toy.sian.spring.event.interfaces.rest.request

import toy.sian.spring.event.application.CreateProductProcessor

data class CreateProductRequest(
    val name: String,
    val price: Long,
    val quantity: Long,
) {
    fun toCommand(): CreateProductProcessor.Command {
        return CreateProductProcessor.Command(
            name = name,
            price = price,
            quantity = quantity,
        )
    }
}
