package rule

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class GameRuleTest {

    @ParameterizedTest
    @ValueSource(ints = [0, 3])
    fun `숫자를 받아 0이상 3이하일 경우 false를 반환`(value: Int) {
        assertThat(GameRule.isForward(value)).isEqualTo(false)
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 9])
    fun `숫자를 받아 0이상 3이하일 경우 true를 반환`(value: Int) {
        assertThat(GameRule.isForward(value)).isEqualTo(true)
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 10])
    fun `숫자를 받아 0이상 9이하가 아닐 경우 null를 반환`(value: Int) {
        assertThat(GameRule.isForward(value)).isNull()
    }

    @Test
    fun `전진 횟수들을 받아 우승자의 전진 횟수를 반환`() {
        val values: List<Int> = listOf(10, 0, 1, 2, 10, 9, 8)
        assertThat(GameRule.getWinnerForwardCount(values)).isEqualTo(10)
    }
}
