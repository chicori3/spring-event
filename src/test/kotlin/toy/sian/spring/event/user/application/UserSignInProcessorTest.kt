package toy.sian.spring.event.user.application

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.string.beBlank
import org.springframework.boot.test.context.SpringBootTest
import toy.sian.spring.event.user.domain.User
import toy.sian.spring.event.user.domain.UserRepository

@SpringBootTest
class UserSignInProcessorTest(
    private val sut: UserSignInProcessor,
    private val userRepository: UserRepository,
) : DescribeSpec(
    {
        beforeSpec {
            userRepository.save(
                User(
                    email = "test@test.com",
                    nickname = "test-user",
                ),
            )
        }

        describe("유저 로그인 시") {
            context("유저가 존재하면") {
                it("유저 정보가 반환된다") {
                    val email = "test@test.com"

                    val result = sut.signIn(email)

                    result shouldNotBe null
                    result.userId shouldNotBe null
                    result.email shouldBe email
                    result.token shouldNotBe beBlank()
                }
            }
        }
    },
)
