package car

data class Car(
    val name: Name,
    val forwardCount: ForwardCount = ForwardCount()
) {

    fun moveForward(isMove: Boolean) {
        if (isMove) forwardCount.addCount()
    }

    companion object {
        fun from(name: String, forwardCount: Int = 0): Car = Car(Name((name)), ForwardCount(forwardCount))
    }
}
