package racinggame.controller;

import java.util.List;

import racinggame.domain.Racing;
import racinggame.view.Computer;
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
		Computer.printBeforePlay();
		play(racing);
	}

	public void play(Racing racing) {
		for (int round = 0; round < racing.getRoundCount(); round++) {
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
