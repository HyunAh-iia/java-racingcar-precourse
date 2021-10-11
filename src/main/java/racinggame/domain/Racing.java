package racinggame.domain;

import java.util.List;

import racinggame.domain.wrapper.CarName;
import racinggame.domain.wrapper.ParticipatingCars;
import racinggame.domain.wrapper.Round;
import racinggame.domain.wrapper.Score;
import racinggame.domain.wrapper.Winners;

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
