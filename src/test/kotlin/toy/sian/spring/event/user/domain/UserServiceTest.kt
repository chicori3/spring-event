package toy.sian.spring.event.user.domain

import io.kotest.core.spec.style.BehaviorSpec
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserServiceTest(
    private val sut: UserService,
) : BehaviorSpec({
    given("유저 가입 시") {
        `when`("이메일과 닉네임이 주어지면") {
            val email = "test@test.com"
            val nickname = "test-user"

            then("유저가 생성되고 가입 이벤트가 발행된다") {
                sut.register(email, nickname)
            }
        }
    }
},)
