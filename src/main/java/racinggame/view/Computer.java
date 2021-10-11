package racinggame.view;

import java.util.List;

import racinggame.domain.RacingCar;

public class Computer {
	private static final String MESSAGE_BEFORE_PLAY = "실행 결과";
	private static final String MESSAGE_CURRENT_CAR_STATUS = "%s : %s\n";
	private static final String MESSAGE_BLACK = "";
	private static final String DASH = "-";

	public static void printBeforePlay() {
		System.out.println(MESSAGE_BEFORE_PLAY);
	}

	public static void printRoundResult(List<RacingCar> racingCars) {
		for (RacingCar car : racingCars) {
			String convertedScore = convertScoreToString(car.getCurrentScore());
			System.out.printf(MESSAGE_CURRENT_CAR_STATUS, car.getCarName(), convertedScore);
		}
		System.out.println(MESSAGE_BLACK);
	}

	private static String convertScoreToString(int score) {
		String converted = "";
		for (int i = 0; i < score; i++) {
			converted += DASH;
		}
		return converted;
	}
}
