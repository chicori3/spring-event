package toy.sian.spring.event.user.application

import io.kotest.core.spec.style.BehaviorSpec
import org.springframework.boot.test.context.SpringBootTest
import toy.sian.spring.event.user.application.UserRegisterProcessor

@SpringBootTest
class UserRegisterProcessorTest(
    private val sut: UserRegisterProcessor,
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
