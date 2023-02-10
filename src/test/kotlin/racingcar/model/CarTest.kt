package racingcar.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CarTest {

    lateinit var car: Car

    @BeforeEach
    fun beforeEach() {
        car = Car("otter")
    }

    @Test
    fun `움직임 정상 테스트`() {
        val moveCount = 5

        repeat(moveCount) {
            car.move()
        }

        assertEquals("-".repeat(moveCount), car.getPositionAsDash())
    }
}