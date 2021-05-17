import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author Josef
 *
 */
class playSnakeEyesTest {

	/**
	 * Test method for {@link playSnakeEyes#Roll()}.
	 */
	@Test
	void testRoll() {
		playSnakeEyes TestSnake = new playSnakeEyes(25);
		int[] Dice =TestSnake.Roll();
		System.out.println(Dice[0]);
		System.out.println(Dice[1]);
	}
	@Test
	void TestTurn() {
		playSnakeEyes TestSnake = new playSnakeEyes(25);
		int score = TestSnake.PlayerTurn(0, 25);
		System.out.println("Your score is now " + score);
	}
	

}
