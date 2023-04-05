package car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarsTest {

    @Test
    fun `자동차들을 가진다`() {
        val cars: Cars = Cars(
            listOf<Car>(
                Car.from("크롱"), Car.from("하티"),
                Car.from("글로"), Car.from("부나"),
                Car.from("코비"), Car.from("앜"),
                Car.from("로피"), Car.from("루피")
            )
        )
        assertThat(cars.values).isNotEmpty
    }
}
