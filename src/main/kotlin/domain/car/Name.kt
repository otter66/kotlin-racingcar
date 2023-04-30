package domain.car

@JvmInline
value class Name(
    val value: String
) {
    init {
        require(value.length in MINIMUM_VALUE_LENGTH..MAXIMUM_VALUE_LENGTH) { throw IllegalArgumentException() }
    }

    override fun toString(): String {
        return value
    }

    companion object {
        const val MINIMUM_VALUE_LENGTH: Int = 1
        const val MAXIMUM_VALUE_LENGTH: Int = 5
    }
}
