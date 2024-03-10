package toy.sian.spring.event.user.interfaces

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import toy.sian.spring.event.common.ApiResponse
import toy.sian.spring.event.user.application.UserFacade

@RestController
@RequestMapping("/users")
class UserController(
    private val userFacade: UserFacade,
) {
    @PostMapping("/sign-in")
    fun signIn(@RequestBody request: SignInRequest): ApiResponse<Any> {
        userFacade.signIn(request.email)
        return ApiResponse.success(null)
    }

    data class SignInRequest(
        val email: String,
    )
}
