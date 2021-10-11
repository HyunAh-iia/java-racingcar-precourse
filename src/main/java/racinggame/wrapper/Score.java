package racinggame.wrapper;

public class Score {
	private static final int DEFAULT_SCORE = 0;
	private static final String MESSAGE_TO_LOW = "스코어는 " + DEFAULT_SCORE + " 이상만 입력할 수 있습니다.";

	private int score;

	public Score() {
		this.score = DEFAULT_SCORE;
	}

	public Score(int score) {
		validate(score);
		this.score = score;
	}

	public int get() {
		return this.score;
	}

	public void addScore(int score) {
		this.score += score;
	}

	public void update(int score) {
		validate(score);
		this.score = score;
	}

	private void validate(int score) {
		if (score < DEFAULT_SCORE) {
			throw new IllegalArgumentException(MESSAGE_TO_LOW);
		}
	}
}
