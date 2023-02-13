package racingcar.service

import racingcar.model.Car
import racingcar.utils.Random

class RacingService {

    fun createCar(carName: String) = Car(carName)

    fun moveRandomly(car: Car) {
        car.move(isMove())
    }

    fun isMove(): Boolean {
        return pickRandomMoveProbability() >= MOVEMENT_PROBABILITY
    }

    private fun pickRandomMoveProbability(): Int {
        return Random.pickInRange(START_RANDOM_MOVEMENT_PROBABILITY, END_RANDOM_MOVEMENT_PROBABILITY)
    }

    fun getWinners(cars: List<Car>): List<Car> {
        val winnerStandard = cars.max()
        return cars.filter { it == winnerStandard }
    }

    companion object {
        const val START_RANDOM_MOVEMENT_PROBABILITY = 1
        const val END_RANDOM_MOVEMENT_PROBABILITY = 10
        const val MOVEMENT_PROBABILITY = 4
    }
}
