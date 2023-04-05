package car

import random.RandomGenerator
import random.RandomGenerator.FORWARD_RANDOM_RANGE
import rule.GameRule

class Cars(
    val values: List<Car>
) {
    fun moveRandomForward() {
        values.forEach {
            val randomNumber: Int = RandomGenerator.getRandomNumberInRange(FORWARD_RANDOM_RANGE)
            val isMove: Boolean = GameRule.isForward(randomNumber) ?: false
            it.moveForward(isMove)
        }
    }
}
