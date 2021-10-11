package racinggame.wrapper;

import nextstep.utils.Randoms;

public class MovingScore {
	private static final int GO = 4;
	private static final int MIN_NUMBER = 0;
	private static final int MAX_NUMBER = 9;
	private static final int GO_SCORE = 1;
	private static final int STOP_SCORE = 0;

	public static int get() {
		return getRandom() >= GO ? GO_SCORE : STOP_SCORE;
	}

	private static int getRandom() {
		return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
	}
}
