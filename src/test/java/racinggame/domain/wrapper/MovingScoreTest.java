package racinggame.domain.wrapper;

import static org.assertj.core.api.Assertions.*;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.test.NSTest;
import racinggame.Application;

public class MovingScoreTest extends NSTest {
	private static final int GO = 4;
	private static final int STOP = 3;
	private static final int GO_SCORE = 1;
	private static final int STOP_SCORE = 0;

	@BeforeEach
	void beforeEach() {
		setUp();
	}

	@DisplayName("랜덤값에 따른 전진 검증")
	@Test
	void goWhenBiggerThanValueTest() {
		MovingScore score = new MovingScore();
		AtomicInteger totalScore = new AtomicInteger();
		assertRandomTest(() -> {
			totalScore.set(score.get());
		}, GO);
		assertThat(totalScore.get()).isEqualTo(GO_SCORE);
	}

	@DisplayName("랜덤값에 따른 정 검증")
	@Test
	void stopWhenLowerThanValueTest() {
		MovingScore score = new MovingScore();
		AtomicInteger totalScore = new AtomicInteger();
		assertRandomTest(() -> {
			totalScore.set(score.get());
		}, STOP);
		assertThat(totalScore.get()).isEqualTo(STOP_SCORE);
	}

	@AfterEach
	void tearDown() {
		outputStandard();
	}

	@Override
	public void runMain() {
		Application.main(new String[] {});
	}
}
