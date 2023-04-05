package car

class Car(
    val name: Name
) {

    companion object {
        fun from(name: String): Car = Car(Name((name)))
    }
}
