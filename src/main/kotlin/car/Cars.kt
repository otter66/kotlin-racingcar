package car

import random.RandomGenerator
import random.RandomGenerator.FORWARD_RANDOM_RANGE
import rule.GameRule

data class Cars(
    val values: List<Car>
) {

    constructor(carNames: List<String>) : this(carNames.map { Car(Name(it)) })

    fun moveRandomForward() {
        values.forEach {
            val randomNumber: Int = RandomGenerator.getRandomNumberInRange(FORWARD_RANDOM_RANGE)
            val isMove: Boolean = GameRule.isForward(randomNumber) ?: false
            it.moveForward(isMove)
        }
    }

    fun getWinners(): Cars {
        val winForwardCount: Int = GameRule.getWinnerForwardCount(values.map { it.forwardCount.toInt() })
        val winners: List<Car> = values.filter { it.forwardCount.toInt() == winForwardCount }
        return Cars(winners)
    }
}
