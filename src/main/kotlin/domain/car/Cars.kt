package domain.car

import domain.random.RandomGenerator
import domain.random.RandomGenerator.FORWARD_RANDOM_RANGE
import domain.rule.GameRule

data class Cars(
    val values: List<Car>
) {

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

    companion object {
        fun from(names: List<String>): Cars = Cars(names.map { Car.from(it) })
    }
}
