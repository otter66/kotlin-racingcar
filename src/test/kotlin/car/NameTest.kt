package car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class NameTest {

    @Test
    fun `문자열을 가진다`() {
        val carName: Name = Name("hello")
        assertThat(carName.value).isNotEmpty
    }
}
