package racinggame.view;

import java.util.ArrayList;
import java.util.List;

import racinggame.domain.RacingCar;

public class Computer {
	private static final String MESSAGE_BEFORE_PLAY = "실행 결과";
	private static final String MESSAGE_CURRENT_CAR_STATUS = "%s : %s\n";
	private static final String MESSAGE_FINAL_WINNERS = "최종 우승자는 %s 입니다.";
	private static final String MESSAGE_BLACK = "";
	private static final String DASH = "-";
	private static final String DELIMITER = ",";

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

	public static void printWinners(List<RacingCar> winners) {
		List<String> winnersNames = new ArrayList<>();
		for (RacingCar winner : winners) {
			winnersNames.add(winner.getCarName());
		}
		String allNames = String.join(DELIMITER, winnersNames);
		System.out.printf(MESSAGE_FINAL_WINNERS, allNames);
	}

	private static String convertScoreToString(int score) {
		String converted = "";
		for (int i = 0; i < score; i++) {
			converted += DASH;
		}
		return converted;
	}
}
