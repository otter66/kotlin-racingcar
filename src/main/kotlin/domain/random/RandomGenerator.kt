package domain.random

object RandomGenerator {

    val FORWARD_RANDOM_RANGE: IntRange = 0..9

    fun getRandomNumberInRange(range: IntRange) = range.random()
}
