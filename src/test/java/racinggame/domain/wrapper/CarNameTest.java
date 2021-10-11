package racinggame.domain.wrapper;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarNameTest {
	@DisplayName("올바른 자동차 이름 등록")
	@Test
	void validateCarNameTest() {
		String carName = "iia";
		CarName name = new CarName(carName);
		assertThat(name.get()).isEqualTo(carName);
	}

	@DisplayName("자동차의 이름은 5글자 이하만 가능")
	@Test
	void carNameLengthLowerThenMaxTest() {
		String carName = "hannah";

		assertThatIllegalArgumentException()
			.isThrownBy(() -> new CarName(carName))
			.withMessageContaining("자동차의 이름은 다섯 글자 이하로 입력하셔야합니다.");
	}

	@DisplayName("자동차의 이름은 1글자 이상만 가능")
	@Test
	void carNameLengthBiggerThenMinTest() {
		String carName = "";

		assertThatIllegalArgumentException()
			.isThrownBy(() -> new CarName(carName))
			.withMessageContaining("자동차의 이름은 한 글자 이상 입력하셔야합니다.");
	}
}
