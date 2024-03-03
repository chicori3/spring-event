package toy.sian.spring.event.common

data class ApiResponse<T>(
    val success: Boolean = true,
    val data: T? = null,
    val error: Error?,
) {
    companion object {
        fun <T> success(data: T?): ApiResponse<T> {
            return ApiResponse(
                success = true,
                data = data,
                error = null,
            )
        }

        fun <T> fail(
            code: String,
            message: String?,
            properties: Map<String, Any?> = mapOf(),
        ): ApiResponse<T> {
            return ApiResponse(
                success = false,
                data = null,
                error = Error(
                    code = code,
                    message = message,
                    properties = properties,
                ),
            )
        }
    }
}

data class Error(
    val code: String,
    val message: String?,
    val properties: Map<String, Any?> = mapOf(),
)
