package car

class Car(
    val name: Name,
    val forwardCount: ForwardCount = ForwardCount()
) {

    companion object {
        fun from(name: String): Car = Car(Name((name)))
    }
}
