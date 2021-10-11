package racinggame.domain;

import racinggame.wrapper.CarName;
import racinggame.wrapper.Score;

public class RacingCar {
	private CarName carName;
	private Score currentScore;

	public RacingCar(CarName carName) {
		this.carName = carName;
		this.currentScore = new Score();
	}

	public String getCarName() {
		return this.carName.get();
	}

	public int getCurrentScore() {
		return this.currentScore.get();
	}
}
