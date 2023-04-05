package rule

import org.assertj.core.api.Assertions.assertThat
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
}
