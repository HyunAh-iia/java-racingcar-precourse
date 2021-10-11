package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

import racinggame.wrapper.CarName;

public class Racing {
	private List<RacingCar> racingCars;
	private int roundCount;

	public Racing(List<CarName> carNames, int roundCount) {
		this.racingCars = joinCars(carNames);
		this.roundCount = roundCount;
	}

	private List<RacingCar> joinCars(List<CarName> carNames) {
		List<RacingCar> racingCars = new ArrayList<>();
		for (CarName name : carNames) {
			racingCars.add(new RacingCar(name));
		}
		return racingCars;
	}

	public List<RacingCar> getRacingCars() {
		return this.racingCars;
	}

	public int getRoundCount() {
		return this.roundCount;
	}

	public void nextRound() {
		racingCars.forEach(car -> car.move());
	}
}
