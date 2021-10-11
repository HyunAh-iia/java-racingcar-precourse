package racinggame.domain.wrapper;

public class Round {
	public static final String MESSAGE_MUST_BIGGER_THAN = "라운드 횟수는 1 이상이어야 합니다.";
	public static final int MIN_ROUND = 1;
	private int round;

	public Round(int round) {
		if (round < MIN_ROUND) {
			throw new IllegalArgumentException(MESSAGE_MUST_BIGGER_THAN);
		}
		this.round = round;
	}

	public int get() {
		return this.round;
	}
}
