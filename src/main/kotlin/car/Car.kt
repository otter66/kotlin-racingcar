package car

class Car(
    val name: Name,
    val forwardCount: ForwardCount = ForwardCount()
) {

    fun moveForward(isMove: Boolean) {
        if (isMove) forwardCount.addCount()
    }

    companion object {
        fun from(name: String): Car = Car(Name((name)))
    }
}
