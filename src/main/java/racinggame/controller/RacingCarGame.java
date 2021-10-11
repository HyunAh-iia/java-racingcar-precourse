package racinggame.controller;

import java.util.List;

import racinggame.domain.Racing;
import racinggame.view.Player;
import racinggame.wrapper.CarName;

public class RacingCarGame {
	public RacingCarGame() {
		start();
	}

	public void start() {
		List<CarName> carNames = Player.writeDownCarNames();
		int roundCount = Player.writeDownRoundCount();
		prepare(carNames, roundCount);
	}

	public void prepare(List<CarName> carNames, int roundCount) {
		Racing racing = new Racing(carNames, roundCount);
	}

	public void play() {

	}

	public void finish() {

	}
}
