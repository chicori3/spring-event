package toy.sian.spring.event.user.domain

data class UserSignIn(
    val userId: Long,
    val email: String,
    val token: String,
)
