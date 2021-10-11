package racinggame.view;

import nextstep.utils.Console;

public class Player {
	private static final String ERROR_PREFIX = "[ERROR] ";
	private static final String WRITE_DOWN_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String WRITE_DOWN_ROUND_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
	private static final String WRONG_CAR_NAMES_ERROR_MESSAGE = ERROR_PREFIX + "자동차 이름은 쉼표로 구분하며, 5자 이하만 입력할 수 있습니다.";
	private static final String WRONG_ROUND_COUNT_ERROR_MESSAGE = ERROR_PREFIX + "시도 회수는 양의 정수만 입력 가능합니다.";
	private static final String SEPARATOR = ",";
	private static final int MAX_CAR_NAME = 5;

	public static String[] writeDownCarNames() {
		System.out.println(WRITE_DOWN_CAR_NAMES_MESSAGE);
		try {
			return validateCarNames(Console.readLine());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return writeDownCarNames();
		}
	}

	public static int writeDownRoundCount() {
		System.out.println(WRITE_DOWN_ROUND_COUNT_MESSAGE);
		try {
			return validateRoundCount(Console.readLine());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return writeDownRoundCount();
		}
	}

	private static String[] validateCarNames(String carNames) {
		String[] separatedNames = carNames.split(SEPARATOR);
		int validated = 0;
		for (int i = 0; i < separatedNames.length; i++) {
			validated += isLengthLowerOrEqual(separatedNames[i]) ? 1 : 0;
		}
		if (validated != separatedNames.length) {
			throw new IllegalArgumentException(WRONG_CAR_NAMES_ERROR_MESSAGE);
		}
		return separatedNames;
	}

	private static int validateRoundCount(String roundCount) {
		try {
			return Integer.parseInt(roundCount);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(WRONG_ROUND_COUNT_ERROR_MESSAGE);
		}
	}

	private static boolean isLengthLowerOrEqual(String carName) {
		return !!(carName.length() <= MAX_CAR_NAME);
	}
}
