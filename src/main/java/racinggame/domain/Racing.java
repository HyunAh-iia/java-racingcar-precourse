package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

import racinggame.wrapper.CarName;
import racinggame.wrapper.Round;

public class Racing {
	private List<RacingCar> racingCars;
	private Round totalRound;

	public Racing(List<CarName> carNames, Round totalRound) {
		this.racingCars = joinCars(carNames);
		this.totalRound = totalRound;
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

	public int getTotalRound() {
		return this.totalRound.get();
	}

	public void nextRound() {
		racingCars.forEach(car -> car.move());
	}
}
