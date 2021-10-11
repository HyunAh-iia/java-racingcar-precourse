package racinggame.domain.wrapper;

import java.util.ArrayList;
import java.util.List;

import racinggame.domain.RacingCar;

public class ParticipatingCars {
	private final List<RacingCar> racingCars;

	public ParticipatingCars(List<RacingCar> racingCars) {
		this.racingCars = racingCars;
	}

	public static ParticipatingCars join(List<CarName> carNames) {
		List<RacingCar> racingCars = new ArrayList<>();
		for (CarName name : carNames) {
			racingCars.add(new RacingCar(name));
		}
		return new ParticipatingCars(racingCars);
	}

	public List<RacingCar> get() {
		return racingCars;
	}

	public void move() {
		racingCars.forEach(car -> car.move());
	}
}
