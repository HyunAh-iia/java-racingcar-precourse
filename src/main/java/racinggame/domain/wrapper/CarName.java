package racinggame.domain.wrapper;

public class CarName {
	private static final String MESSAGE_TOO_SHORT = "자동차의 이름은 한 글자 이상 입력하셔야합니다.";
	private static final String MESSAGE_TOO_LONG = "자동차의 이름은 다섯 글자 이하로 입력하셔야합니다.";
	private static final int MAX_CAR_NAME = 5;
	private String carName;

	public CarName(String carName) {
		if (carName == null || carName.isEmpty()) {
			throw new IllegalArgumentException(MESSAGE_TOO_SHORT);
		}
		if (carName.length() > MAX_CAR_NAME) {
			throw new IllegalArgumentException(MESSAGE_TOO_LONG);
		}
		this.carName = carName;
	}

	public String get() {
		return this.carName;
	}
}
