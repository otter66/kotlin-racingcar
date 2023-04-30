package domain.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ForwardCountTest {

    @Test
    fun `숫자를 가진다`() {
        val forwardCount: ForwardCount = ForwardCount(5)
        assertThat(forwardCount.toInt()).isEqualTo(5)
    }

    @Test
    fun `숫자를 증가시킨다`() {
        val forwardCount: ForwardCount = ForwardCount()
        forwardCount.addCount()
        assertThat(forwardCount.toInt()).isEqualTo(1)
    }
}
