package toy.sian.spring.event.user.application

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserRegisterProcessorTest(
    private val sut: UserRegisterProcessor,
) :  DescribeSpec(
    {
        describe("유저 가입 시") {
            context("이메일과 닉네임이 주어지면") {
                it("유저가 생성된다") {
                    val email = "test@test.com"
                    val nickname = "test-user"

                    val result = sut.register(email, nickname)

                    result.email shouldBe email
                    result.nickname shouldBe nickname
                }
            }
        }
    }
)
