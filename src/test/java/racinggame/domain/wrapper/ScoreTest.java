package racinggame.domain.wrapper;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ScoreTest {
	@DisplayName("초기 점수의 디폴트값 검증")
	@Test
	void scoreDefaultTest() {
		int defaultValue = 0;
		Score score = new Score();
		assertThat(score).isEqualTo(defaultValue);
	}

	@DisplayName("양의 정수가 아닌 점수를 더하거나 변경할 경우 오류")
	@Test
	void scoreAllowOnlyPositiveValue() {
		int negativeValue = -1;
		Score score = new Score();

		assertThatIllegalArgumentException()
			.isThrownBy(() -> score.addScore(negativeValue))
			.withMessageContaining("이상만 입력할 수 있습니다.");
		assertThatIllegalArgumentException()
			.isThrownBy(() -> score.update(negativeValue))
			.withMessageContaining("이상만 입력할 수 있습니다.");
	}
}
