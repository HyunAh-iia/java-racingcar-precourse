package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racinggame.wrapper.CarName;

public class RacingCarTest {

	@DisplayName("올바른 이름을 넣었을 때 자동차 생성 검증")
	@Test
	void createRacingCarTest() {
		String carName = "iia";
		RacingCar racingCar = new RacingCar(new CarName(carName));
		assertThat(racingCar.getCarName()).isEqualTo(carName);
	}

	@DisplayName("올바르지 않은 이름을 넣었을 때 오류 검증")
	@ValueSource(strings = {"", "hannah"})
	@ParameterizedTest
	void createRacingCarWithWrongNameTest(String input) {
		assertThatIllegalArgumentException().isThrownBy(() ->
			new RacingCar(new CarName(input))
		);
	}
}
