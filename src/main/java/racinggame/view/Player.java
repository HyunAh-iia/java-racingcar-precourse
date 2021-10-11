package racinggame.view;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Console;
import racinggame.domain.wrapper.CarName;
import racinggame.domain.wrapper.Round;

public class Player {
	private static final String ERROR_PREFIX = "[ERROR] ";
	private static final String MESSAGE_WRITE_DOWN_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String MESSAGE_WRITE_DOWN_ROUND_COUNT = "시도할 회수는 몇회인가요?";
	private static final String MESSAGE_ROUND_COUNT_ONLY_POSITIVE = "시도 회수는 양의 정수만 입력 가능합니다.";
	private static final String MESSAGE_MUST_WRITE = "";
	private static final String SEPARATOR = ",";

	public static List<CarName> writeDownCarNames() {
		System.out.println(MESSAGE_WRITE_DOWN_CAR_NAMES);
		try {
			return validateCarNames(Console.readLine());
		} catch (IllegalArgumentException e) {
			System.out.println(ERROR_PREFIX + e.getMessage());
			return writeDownCarNames();
		}
	}

	public static Round writeDownRoundCount() {
		System.out.println(MESSAGE_WRITE_DOWN_ROUND_COUNT);
		try {
			return validateRoundCount(Console.readLine());
		} catch (IllegalArgumentException e) {
			System.out.println(ERROR_PREFIX + e.getMessage());
			return writeDownRoundCount();
		}
	}

	private static List<CarName> validateCarNames(String carNames) {
		String[] separatedNames = carNames.split(SEPARATOR, -1);
		List<CarName> carNameList = new ArrayList<>();
		for (int i = 0; i < separatedNames.length; i++) {
			carNameList.add(new CarName(separatedNames[i]));
		}
		return carNameList;
	}

	private static Round validateRoundCount(String roundCount) {
		try {
			return new Round(Integer.parseInt(roundCount));
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(MESSAGE_ROUND_COUNT_ONLY_POSITIVE);
		}
	}
}
