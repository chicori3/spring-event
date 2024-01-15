package toy.sian.spring.event.application

import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.springframework.context.ApplicationEventPublisher
import toy.sian.spring.event.domain.Product
import toy.sian.spring.event.domain.exception.ProductIllegalArgumentException
import toy.sian.spring.event.event.ProductCreated
import toy.sian.spring.event.infra.ProductRepositoryAdapter

class CreateProductProcessorSpec {
    private lateinit var sut: CreateProductProcessor

    private lateinit var productRepository: ProductRepositoryAdapter
    private lateinit var eventPublisher: ApplicationEventPublisher

    @BeforeEach
    fun init() {
        productRepository = mockk(relaxed = true)
        eventPublisher = mockk(relaxed = true)

        sut = CreateProductProcessor(productRepository, eventPublisher)
    }

    @Test
    fun `상품이_생성되면_이벤트를 발행한다`() {
        val command = CreateProductProcessor.Command(
            name = "테스트 상품",
            price = 100_000,
            quantity = 10,
        )

        sut.execute(command)

        verify(exactly = 1) { eventPublisher.publishEvent(ofType(ProductCreated::class)) }
        verify(exactly = 1) { productRepository.save(ofType(Product::class)) }
    }

    @ParameterizedTest
    @MethodSource("illegalCreateProductCommand")
    fun `유효하지_않은_상품을_생성하면_예외가_발생한다`(command: CreateProductProcessor.Command) {
        assertThatThrownBy { sut.execute(command) }
            .isInstanceOf(ProductIllegalArgumentException::class.java)
    }

    companion object {
        @JvmStatic
        fun illegalCreateProductCommand() = listOf(
            Arguments.of(
                CreateProductProcessor.Command(
                    name = "테스트 상품",
                    price = -1,
                    quantity = 10,
                )
            ),
            Arguments.of(
                CreateProductProcessor.Command(
                    name = "테스트 상품",
                    price = 100_000,
                    quantity = -1,
                )
            ),
            Arguments.of(
                CreateProductProcessor.Command(
                    name = "",
                    price = 100_000,
                    quantity = 0,
                )
            )
        )
    }
}
