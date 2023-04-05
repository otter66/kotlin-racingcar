package car

data class ForwardCount(
    private var value: Int = 0
) {

    fun toInt() = value

    fun addCount() = value++
}
