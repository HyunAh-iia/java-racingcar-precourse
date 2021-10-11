package racinggame.controller;

import java.util.List;

import racinggame.domain.Racing;
import racinggame.domain.wrapper.CarName;
import racinggame.domain.wrapper.Round;
import racinggame.view.Computer;
import racinggame.view.Player;

public class RacingCarGame {
	public RacingCarGame() {
		start();
	}

	public void start() {
		List<CarName> carNames = Player.writeDownCarNames();
		Round totalRound = Player.writeDownRoundCount();
		prepare(carNames, totalRound);
	}

	private void prepare(List<CarName> carNames, Round totalRound) {
		Racing racing = new Racing(carNames, totalRound);
		Computer.printBeforePlay();
		play(racing);
	}

	private void play(Racing racing) {
		for (int round = 0; round < racing.getTotalRound(); round++) {
			racing.nextRound();
			Computer.printRoundResult(racing.getRacingCars());
		}
		finish(racing);
	}

	private void finish(Racing racing) {
		racing.finish();
		Computer.printWinners(racing.getWinners());
	}
}
