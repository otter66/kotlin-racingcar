package racingcar.model

class Car(
    private val name: String,
    private var position: Int = 0
) : Comparable<Car> {

    fun move() = ++position

    override fun compareTo(other: Car) = this.position - other.position

    override fun equals(other: Any?): Boolean {
        if (other is Car) {
            return this.position == other.position
        }

        return false
    }

    override fun toString() = name

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + position
        return result
    }
}