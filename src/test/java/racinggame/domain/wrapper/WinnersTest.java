package racinggame.domain.wrapper;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racinggame.domain.RacingCar;

public class WinnersTest {
	@DisplayName("우승자가 한 명일 때")
	@Test
	void oneWinner() {
		int maxScore = 0;
		List<RacingCar> cars = new ArrayList<>();
		cars.add(new RacingCar(new CarName("one")));

		Winners winners = new Winners(cars, maxScore);

		assertThat(winners.whoAreTheFinal().size()).isEqualTo(cars.size());
	}

	@DisplayName("우승자가 한 명 이상일 때")
	@Test
	void twoWinner() {
		int maxScore = 0;
		List<RacingCar> cars = new ArrayList<>();
		cars.add(new RacingCar(new CarName("one")));
		cars.add(new RacingCar(new CarName("two")));

		Winners winners = new Winners(cars, maxScore);

		assertThat(winners.whoAreTheFinal().size()).isEqualTo(cars.size());
	}
}
