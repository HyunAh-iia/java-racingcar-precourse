package racinggame.domain.wrapper;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RoundTest {
	private static final int MIN_ROUND = 1;

	@DisplayName("라운드 수를 최소값 이상으로 설정 시 정상")
	@Test
	void roundBiggerOrEqualThenMinTest() {
		assertThat(new Round(MIN_ROUND).get()).isEqualTo(MIN_ROUND);
	}

	@DisplayName("라운드 수를 최소값 미만으로 설정 시 오류")
	@Test
	void roundLowerThanMinTest() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new Round(MIN_ROUND - 1))
			.withMessageContaining("라운드 횟수는 1 이상이어야 합니다.");
	}
}
