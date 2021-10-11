package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racinggame.wrapper.CarName;

public class RacingTest {
	@DisplayName("레이싱 게임에 참여할 자동차들 존재 검증")
	@Test
	void existRacingCarsWhenCreateRacingTest() {
		String[] carNames = new String[] {"one", "two"};
		int roundCount = 5;

		List<CarName> racingCarNames = new ArrayList<>(
			Arrays.asList(new CarName(carNames[0]), new CarName(carNames[1])));
		Racing racing = new Racing(racingCarNames, roundCount);

		for (int i = 0; i < carNames.length; i++) {
			assertThat(carNames).contains(racing.getRacingCars().get(i).getCarName());
		}
	}
}
