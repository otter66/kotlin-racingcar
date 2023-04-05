package car

class Car(
    val name: Name,
    val forwardCount: ForwardCount = ForwardCount()
) {

    fun moveForward() = forwardCount.addCount()

    companion object {
        fun from(name: String): Car = Car(Name((name)))
    }
}
