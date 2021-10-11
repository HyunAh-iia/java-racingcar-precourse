package racinggame.domain;

import nextstep.utils.Randoms;
import racinggame.wrapper.CarName;
import racinggame.wrapper.Score;

public class RacingCar {
	private static final int GO = 4;

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

	public void move() {
		//todo refactor
		int random = Randoms.pickNumberInRange(0, 9);
		int gainScore = random >= GO ? 1 : 0;
		currentScore.addScore(gainScore);
	}
}
