package racingcar.service

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import racingcar.model.Car
import java.util.stream.Stream
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

internal class RacingServiceTest {

    private lateinit var racingService: RacingService

    @BeforeEach
    fun beforeEach() {
        this.racingService = RacingService()
    }

    @ParameterizedTest
    @ValueSource(ints = [9, 6, 4])
    fun `발행된 전진 확률이 4~9일 때 isMove 메서드가 true를 반환합니다`(moveProbability: Int) {
        assertEquals(
            racingService.isMove(moveProbability),
            true
        )
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 3])
    fun `발행된 전진 확률이 0~3일 때 isMove 메서드가 false를 반환합니다`(moveProbability: Int) {
        assertEquals(
            racingService.isMove(moveProbability),
            false
        )
    }

    @ParameterizedTest
    @ValueSource(strings = ["buna", "sooda"])
    fun `자동차 이름의 글자 수가 1~5자에 해당 할 때 객체를 생성합니다`(carName: String) {
    @ValueSource(strings = ["buna", "sooda"])
    fun `자동차 객체 생성 정상 테스트`(carName: String) {
        assertDoesNotThrow {
            racingService.createCar(carName)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["soooodal", "buuuuuuuna", ""])
    fun `자동차 이름의 글자 수가 1~5자에 해당 하지 않을 때 객체 생성에 에러가 발생합니다`(carName: String) {
    fun `자동차 객체 생성 예외 테스트`(carName: String) {
        assertThrows<IllegalArgumentException> {
            racingService.createCar(carName)
        }
    }

    @ParameterizedTest
    @MethodSource("provideCarsForHappyCase")
    fun `각 자동차의 전진 횟수에 따라 산출된 우승자 리스트가 일치합니다`(cars: List<Car>, expectedWinnersCount: Int) {
    fun `최종 우승자 산출 정상 테스트`(cars: List<Car>, expectedWinnersCount: Int) {
        val realWinnersCount = racingService.getWinners(cars).size
        assertEquals(realWinnersCount, expectedWinnersCount)
    }

    @ParameterizedTest
    @MethodSource("provideCarsForExceptionCase")
    fun `최종 우승자 산출 예외 테스트`(cars: List<Car>, expectedWinnersCount: Int) {
        val realWinnersCount = racingService.getWinners(cars).size
        assertNotEquals(realWinnersCount, expectedWinnersCount)
    }

    companion object {
        @JvmStatic
        fun provideCarsForHappyCase(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    listOf(
                        Car("sooda", 7),
                        Car("buna", 6),
                        Car("sunny", 2),
                    ),
                    1
                ),
                Arguments.of(
                    listOf(
                        Car("sooda", 7),
                        Car("buna", 7),
                        Car("sunny", 7),
                    ),
                    3
                ),
                Arguments.of(
                    listOf(
                        Car("sooda", 0),
                        Car("buna", 0),
                        Car("sunny", 0),
                    ),
                    3
                ),
            )
        }

        @JvmStatic
        fun provideCarsForExceptionCase(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    listOf(
                        Car("sooda", 7),
                        Car("buna", 6),
                        Car("sunny", 2),
                    ),
                    2
                ),
                Arguments.of(
                    listOf(
                        Car("sooda", 7),
                        Car("buna", 2),
                        Car("sunny", 7),
                    ),
                    1
                ),
                Arguments.of(
                    listOf(
                        Car("sooda", 0),
                        Car("buna", 0),
                        Car("sunny", 0),
                    ),
                    0
                ),
                Arguments.of(
                    listOf(
                        Car("sooda", 1),
                        Car("buna", 2),
                        Car("sunny", 3),
                    ),
                    4
                ),
            )
        }
    }
}
