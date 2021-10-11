package racinggame.controller;

import java.util.List;

import racinggame.domain.Racing;
import racinggame.view.Computer;
import racinggame.view.Player;
import racinggame.wrapper.CarName;
import racinggame.wrapper.Round;

public class RacingCarGame {
	public RacingCarGame() {
		start();
	}

	public void start() {
		List<CarName> carNames = Player.writeDownCarNames();
		Round totalRound = Player.writeDownRoundCount();
		prepare(carNames, totalRound);
	}

	public void prepare(List<CarName> carNames, Round totalRound) {
		Racing racing = new Racing(carNames, totalRound);
		Computer.printBeforePlay();
		play(racing);
	}

	public void play(Racing racing) {
		for (int round = 0; round < racing.getTotalRound(); round++) {
			racing.nextRound();
			Computer.printRoundResult(racing.getRacingCars());
		}
		finish();
	}

	public void finish() {
		// TODO 우승자 찾기
		// TODO 출력
	}
}
