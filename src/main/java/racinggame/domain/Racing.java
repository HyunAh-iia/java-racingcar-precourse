package racinggame.domain;

import java.util.List;

import racinggame.wrapper.CarName;
import racinggame.wrapper.ParticipatingCars;
import racinggame.wrapper.Round;

public class Racing {
	private ParticipatingCars racingCars;
	private Round totalRound;

	public Racing(List<CarName> carNames, Round totalRound) {
		this.racingCars = ParticipatingCars.join(carNames);
		this.totalRound = totalRound;
	}

	public List<RacingCar> getRacingCars() {
		return this.racingCars.get();
	}

	public int getTotalRound() {
		return this.totalRound.get();
	}

	public void nextRound() {
		racingCars.move();
	}
}
