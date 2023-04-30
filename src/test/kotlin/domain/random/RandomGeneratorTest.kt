package domain.random

import domain.random.RandomGenerator.FORWARD_RANDOM_RANGE
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RandomGeneratorTest {

    @Test
    fun `숫자의 범위를 받아 랜덤 번호를 발행한다`() {
        val randomNumber = RandomGenerator.getRandomNumberInRange(FORWARD_RANDOM_RANGE)
        assertThat(randomNumber in 0..9).isTrue
    }
}
