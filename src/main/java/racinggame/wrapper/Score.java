package racinggame.wrapper;

public class Score {
	private static final int DEFAULT_SCORE = 0;
	private int score;

	public Score() {
		this.score = DEFAULT_SCORE;
	}

	public int get() {
		return this.score;
	}
}
