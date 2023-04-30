package domain.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class NameTest {

    @Test
    fun `문자열을 가진다`() {
        val carName: Name = Name("hello")
        assertThat(carName.value).isNotEmpty
    }

    @ParameterizedTest
    @ValueSource(strings = ["o", "otter"])
    fun `1이상 5이하일 때 생성된다`(value: String) {
        assertDoesNotThrow { Name(value) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "apupupu"])
    fun `1이상 5이하가 아닐 때 에러를 발생시킨다`(value: String) {
        assertThrows<IllegalArgumentException> { Name(value) }
    }

    @Test
    fun `외부에서 객체를 쓰고자 할 때 가지고 있는 문자열을 반환한다`() {
        val carName: Name = Name("hello")
        assertThat(carName.toString()).isEqualTo("hello")
    }
}
