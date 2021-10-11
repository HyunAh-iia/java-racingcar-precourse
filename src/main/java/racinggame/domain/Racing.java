package racinggame.domain;

import java.util.List;

import racinggame.wrapper.CarName;
import racinggame.wrapper.ParticipatingCars;
import racinggame.wrapper.Round;
import racinggame.wrapper.Score;
import racinggame.wrapper.Winners;

public class Racing {
	private ParticipatingCars racingCars;
	private Round totalRound;
	private Score maxScore;
	private Winners winners;

	public Racing(List<CarName> carNames, Round totalRound) {
		this.racingCars = ParticipatingCars.join(carNames);
		this.totalRound = totalRound;
		this.maxScore = new Score();
	}

	public List<RacingCar> getRacingCars() {
		return this.racingCars.get();
	}

	public int getTotalRound() {
		return this.totalRound.get();
	}

	public void nextRound() {
		racingCars.move();
		this.maxScore.update(getCurrentMaxScore());
	}

	public List<RacingCar> getWinners() {
		return winners.whoAreTheFinal();
	}

	public void finish() {
		this.winners = new Winners(getRacingCars(), this.maxScore.get());
	}

	private int getCurrentMaxScore() {
		int max = 0;
		for (RacingCar car : this.racingCars.get()) {
			max = car.getCurrentScore() > max ? car.getCurrentScore() : max;
		}
		return max;
	}
}
