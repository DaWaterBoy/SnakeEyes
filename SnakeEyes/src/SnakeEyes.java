import java.util.Scanner;

/*Player rolls two dice, as many times as they want unless they roll a one, then their turn is over and the sum of the dice rolled in the turn is added to their total. If "Snake Eyes" is rolled (Double ones) the turn is over and they get zero for that turn.
 * Player wins if their total reaches 50 before the Pirates do
 */

public class SnakeEyes {
	/** Sets initial values for Player and Pirates
	 */
	public int PlayerTotal ;
	public int PirateTotal ;
	public int PlayerTurn ;
	public int PirateTurn ;
	public int PlayerHC ;
	
	public int DiceOne;
	public int DiceTwo;
	
	public SnakeEyes(int Handicap) {
		PlayerTotal = Handicap;
		PirateTotal = 0;
		PlayerTurn = 0;
		PirateTurn = 0;
		PlayerHC = Handicap;
		
		DiceOne = 0;
		DiceTwo = 0;
	}
	
	public void Roll() {
		/** Rolls the two dice
		 */
		DiceOne = (int)(Math.random()*6+1);
		DiceTwo = (int)(Math.random()*6+1);
	}
	
	public void PlayerTurn() {
		/** Checks if the player wants to roll again, rolls and adds the sum to the turn total
		 */
		boolean F = false;
		while (F = false) {
			System.out.print("Do you want to roll? ");
			Scanner sc = new Scanner(System.in);  
			boolean rollCheck = sc.nextBoolean();  
			if (rollCheck == true) {
				this.Roll();
				if ((DiceOne == 1) && (DiceTwo == 1)) {
					/** Player rolled two ones, turn fails total score is reset to zero 
					 */
					System.out.println("You rolled Snake Eyes, your score is now Zero!");
					PlayerTotal = this.PlayerHC;
					F = true;
				}
				else if ((DiceOne == 1) || (DiceTwo == 1)) {
					/** Player rolled at least one one and the turn is over
					 */
					PlayerTurn = PlayerTurn + DiceOne + DiceTwo;
					PlayerTotal += PlayerTurn;
					System.out.println("You rolled a one, your turn is over. You got " + PlayerTurn + " points this turn.");
					System.out.println("You now have a total score of : " + PlayerTotal);
					F = true;
					}
				else {
					/** Roll is added to turn score
					 */
					PlayerTurn = PlayerTurn + DiceOne + DiceTwo;
					PlayerTotal += PlayerTurn;
					System.out.println("You rolled a " + DiceOne + "and " + DiceTwo );
					System.out.println("Your total is: " + PlayerTotal);
					System.out.println("Your score this turn so far is: " + PlayerTurn);
					if (PlayerTotal >= 50) { /* makes sure the player doesn't get another turn once they reach 50 */
						F = true;
					}
				}		
			}
			else {
				/** Player has chosen to stop rolling
				 */
				F = true;
			}
		}	
	}
	public void PirateTurn() {
		boolean F = false;
		if (PirateTotal < 50) {
			while (F = false) {
				this.Roll();
				if ((DiceOne == 1) && (DiceTwo == 1)) {
					/** Pirate rolled two ones, turn fails total score is reset to zero 
					 */
					PirateTotal = 0;
					F = true;
				}
				else if ((DiceOne == 1) || (DiceTwo == 1)) {
					/** Pirate rolled at least one one and the turn is over
					 */
					PirateTurn = PirateTurn + DiceOne + DiceTwo;
					PirateTotal += PirateTurn;
					F = true;
					}
				else {
					/** Roll is added to turn score
					 */
					PirateTurn = PirateTurn + DiceOne + DiceTwo;
					PirateTotal += PirateTurn;
					if (PirateTotal >= 50) { /*Ensures the pirate doesn't roll again once they reach 50 */
						F = true;
					}
					/** Pirate randomly decides to roll again or not
					 */
					double coinflip = Math.random();
					if (coinflip < 0.50) {
						F = true;
					}
				}		
			}
		}
	}
	
	public int PlaySnakeEyes() {
		while ((PlayerTotal < 50) && (PirateTotal < 50)) {
			this.PlayerTurn();
			if (PlayerTotal <50) { /* this makes sure the Pirate and Player don't reach 50 at the same time */
				this.PirateTurn();
			}	
		}
		int value = 0;
		if (PlayerTotal >= 50) {
			System.out.println("congratulations you won!");
			value = 0;
		}
		if (PirateTotal >= 50) {
			value = (int)(Math.random()*100);
			System.out.println("You lost the pirates are taking " + value + " worth of goods");	
		}
		return value;
	}
	
	public static void main(String[] args) {
		SnakeEyes TestSnakeEyes = new SnakeEyes(25);
		System.out.print(TestSnakeEyes.PlaySnakeEyes());
	}
}
