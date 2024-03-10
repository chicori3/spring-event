package toy.sian.spring.event.user.application

import org.springframework.stereotype.Service

@Service
class UserFacade(
    private val userRegisterProcessor: UserRegisterProcessor,
    private val userSignInProcessor: UserSignInProcessor,
) {
    fun register(email: String, nickname: String) {
        userRegisterProcessor.register(email, nickname)
    }

    fun signIn(email: String) {
        userSignInProcessor.signIn(email)
    }
}
