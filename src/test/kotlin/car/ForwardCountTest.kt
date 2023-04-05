package car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ForwardCountTest {

    @Test
    fun `숫자를 가진다`() {
        val forwardCount: ForwardCount = ForwardCount(5)
        assertThat(forwardCount.toInt()).isEqualTo(5)
    }

    @Test
    fun `한 칸 전진한다`() {
        val forwardCount: ForwardCount = ForwardCount()
        forwardCount.moveForward()
        assertThat(forwardCount.toInt()).isEqualTo(1)
    }
}
