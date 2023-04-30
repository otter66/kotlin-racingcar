package domain.rule

object GameRule {

    private val NOT_FORWARD_CONDITION: IntRange = 0..3
    private val FORWARD_CONDITION: IntRange = 4..9

    fun isForward(number: Int): Boolean? = when (number) {
        in FORWARD_CONDITION -> true
        in NOT_FORWARD_CONDITION -> false
        else -> null
    }

    fun getWinnerForwardCount(numbers: List<Int>): Int = numbers.max()
}
