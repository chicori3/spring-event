package toy.sian.spring.event.interfaces.handler

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import toy.sian.spring.event.common.ApiResponse
import toy.sian.spring.event.domain.exception.ProductIllegalArgumentException

@RestControllerAdvice
class ApiExceptionHandler {

    @ExceptionHandler(ProductIllegalArgumentException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handle(ex: ProductIllegalArgumentException): ApiResponse<Any?> {
        return ApiResponse.fail(
            code = "PRODUCT_ILLEGAL_ARGUMENT",
            message = ex.message,
        )
    }
}