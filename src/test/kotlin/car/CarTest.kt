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
}
