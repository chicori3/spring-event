package toy.sian.spring.event.interfaces.rest

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import toy.sian.spring.event.application.ProductManager
import toy.sian.spring.event.common.ApiResponse
import toy.sian.spring.event.interfaces.rest.request.CreateProductRequest

@RestController
@RequestMapping("/api/v1/products")
class ProductController(
    private val productManager: ProductManager,
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createProduct(@RequestBody request: CreateProductRequest): ApiResponse<Any?> {
        productManager.createProduct(request.toCommand())
        return ApiResponse.success(null)
    }
}