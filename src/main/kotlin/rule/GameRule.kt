package rule

object GameRule {

    private val NOT_FORWARD_CONDITION = 0..3
    private val FORWARD_CONDITION = 4..9

    fun isForward(number: Int): Boolean? {
        return when (number) {
            in FORWARD_CONDITION -> true
            in NOT_FORWARD_CONDITION -> false
            else -> null
        }
    }
}
