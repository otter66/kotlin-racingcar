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

    @Test
    fun `자동차들을 랜덤으로 전진시킨다`() {
        val cars: Cars = Cars(
            listOf<Car>(
                Car.from("크롱"), Car.from("하티"), Car.from("글로"), Car.from("부나"),
                Car.from("코비"), Car.from("앜"), Car.from("로피"), Car.from("루피"),
                Car.from("톰톰톰"), Car.from("토마스"), Car.from("제이순"), Car.from("제임순"),
                Car.from("멘들"), Car.from("멘델"), Car.from("유전"), Car.from("멧"),
                Car.from("좌멘델"), Car.from("우써니"), Car.from("둘리"), Car.from("공실"),
                Car.from("핑구"), Car.from("핑나"), Car.from("벨벨벨"), Car.from("베르")
            )
        )
        val carsBeforeMoveSum: Int = cars.values.sumOf { it.forwardCount.toInt() }
        cars.moveRandomForward()
        val carsAfterMoveSum: Int = cars.values.sumOf { it.forwardCount.toInt() }
        assertThat(carsBeforeMoveSum).isNotEqualTo(carsAfterMoveSum)
    }

    @Test
    fun `우승자를 선출한다`() {
        val cars: Cars = Cars(
            listOf<Car>(
                Car.from("크롱", 5), Car.from("수달", 5),
                Car.from("부나", 0), Car.from("글모니", 2),
            )
        )
        val expected: Cars = Cars(
            listOf<Car>(
                Car.from("크롱", 5), Car.from("수달", 5)
            )
        )

        assertThat(cars.getWinners().values).isEqualTo(expected.values)
    }
}
