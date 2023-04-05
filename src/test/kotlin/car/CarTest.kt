package car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class CarTest {

    @Test
    fun `자동차 이름을 가진다`() {
        val car: Car = Car.from("Crong")
        assertAll(
            { assertThat(car.name).isNotNull },
            { assertThat(car.name.toString()).isEqualTo("Crong") }
        )
    }

    @Test
    fun `자동차의 전진 횟수를 가진다`() {
        val car: Car = Car.from("Crong")
        assertAll(
            { assertThat(car.forwardCount).isNotNull },
            { assertThat(car.forwardCount.toInt()).isEqualTo(0) }
        )
    }

    @Test
    fun `자동차를 전진시킨다`() {
        val car: Car = Car.from("Crong")
        car.moveForward(true)
        assertThat(car.forwardCount.toInt()).isEqualTo(1)
    }
}
