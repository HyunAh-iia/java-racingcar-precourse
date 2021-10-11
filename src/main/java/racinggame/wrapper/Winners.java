package racinggame.wrapper;

import java.util.ArrayList;
import java.util.List;

import racinggame.domain.RacingCar;

public class Winners {
	private List<RacingCar> winners = new ArrayList<>();

	public Winners(List<RacingCar> racingCars, int maxScore) {
		racingCars.forEach(car -> listUp(car, maxScore));
	}

	public List<RacingCar> whoAreTheFinal() {
		return this.winners;
	}

	private void listUp(RacingCar car, int maxScore) {
		if (car.getCurrentScore() < maxScore) {
			return;
		}
		if (car.getCurrentScore() > maxScore) {
			winners.clear();
		}
		winners.add(car);
	}
}
