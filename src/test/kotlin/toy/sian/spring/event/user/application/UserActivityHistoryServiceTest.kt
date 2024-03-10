package toy.sian.spring.event.user.application

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldNotBe
import org.springframework.boot.test.context.SpringBootTest
import toy.sian.spring.event.history.application.UserActivityHistoryService
import toy.sian.spring.event.user.domain.User
import toy.sian.spring.event.user.domain.UserNotFoundException
import toy.sian.spring.event.user.domain.UserRepository

@SpringBootTest
class UserActivityHistoryServiceTest(
    private val sut: UserActivityHistoryService,
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
                it("로그인 이력이 생성된다") {
                    val userId = 1L

                    val result = sut.handleSignIn(userId)

                    result shouldNotBe null
                }
            }
            context("유저가 존재하지 않으면") {
                it("예외가 발생한다") {
                    val userId = 2L

                    shouldThrow<UserNotFoundException> {
                        sut.handleSignIn(userId)
                    }
                }
            }
        }

        describe("유저 로그아웃 시") {
            context("유저가 존재하면") {
                it("로그아웃 이력이 생성된다") {
                    val userId = 1L

                    val result = sut.handleSignOut(userId)

                    result shouldNotBe null
                }
            }
            context("유저가 존재하지 않으면") {
                it("예외가 발생한다") {
                    val userId = 2L

                    shouldThrow<UserNotFoundException> {
                        sut.handleSignOut(userId)
                    }
                }
            }
        }
    },
)
