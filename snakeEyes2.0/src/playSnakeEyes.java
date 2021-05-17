import java.util.InputMismatchException;
import java.util.Scanner;

public class playSnakeEyes {
	
	public int PlayerTotal ;
	public int PirateTotal ;
	public int PlayerHC ;
	

	public playSnakeEyes(int Handicap) {
		PlayerTotal = Handicap;
		PirateTotal = 0;
		PlayerHC = Handicap;
	}
	
	int getPlayerScore() {
		return PlayerTotal;
	}
	
	int getPirateScore() {
		return PirateTotal;
	}
	
	
	public int[] Roll() {
		int [] Dice = new int[2];
		Dice[0] = (int)(Math.random()*6 +1);
		Dice[1] = (int)(Math.random()*6 +1);
		return Dice;
	}
	
	public int PlayerTurn(int PlayerScore, int HC) {
		/** Checks if the player wants to roll again, rolls and adds the sum to the turn total
		 */
		int TurnValue = 0;
		int total = PlayerScore;
		int handicap = HC;
		
		if (total < handicap) {/** ensures the starting total is not less than the handicap*/
			total = handicap;
		}
		
		boolean F = false;
		while (F == false) {
			Scanner input = new Scanner(System.in);
			System.out.print("Do you want to roll? ");
			try {
				boolean rollCheck = input.nextBoolean();
				if (rollCheck == true) {
					int[] Dice = Roll();
					if ((Dice[0] ==1) &&(Dice[1] ==1)) {
						/** Player rolled two ones, turn fails total score is reset to zero 
						 */
						System.out.println("You rolled Snake Eyes, your score is now Zero!");
						TurnValue = 0;
						total = handicap; //returns the player total to the handicap value
						F = true;
					} else if ((Dice[0] ==1) || (Dice[1] ==1)) {
						/** Player rolled at least one one and the turn is over
						 */
						TurnValue = TurnValue + Dice[0] + Dice[1];
						total = total + Dice[0] + Dice[1];
						System.out.println("You rolled a " + Dice[0] + " and " + Dice[1] );
						System.out.println("You rolled a one, your turn is over. You got " + TurnValue + " points this turn.");
						F = true;
					} else {
						/** Roll is added to turn score
						 */
						TurnValue = TurnValue + Dice[0] + Dice[1];
						total = total + Dice[0] + Dice[1];
						System.out.println("You rolled a " + Dice[0] + " and " + Dice[1] );
						System.out.println("Your score this turn so far is: " + TurnValue);
						System.out.println("Your total is: " + total);
						if (total >= 50) { // makes sure the player doesn't get another turn once they reach 50 
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
			catch (InputMismatchException e) {
				System.out.println("You must enter \"true\" or \"false\"" );
			}
		}
		return total;
	}
	
	public int PirateTurn(int PirateScore) {
		int total = PirateScore;
		int turnValue = 0;
		
		boolean F = false;
		while (F == false) {
			int[] Dice = Roll();
			if ((Dice[0] ==1) &&(Dice[1] ==1)) {/** Pirate rolled two ones, turn fails total score is reset to zero */
				 total = 0;
				 F = true;
			}else if ((Dice[0] ==1) || (Dice[1] ==1)) {
				/** Pirate rolled at least one one and the turn is over
				 */
				turnValue = turnValue + Dice[0] + Dice[1];
				total += turnValue;
				F = true;
			} else {
				turnValue = turnValue + Dice[0] + Dice[1];
				total += turnValue;
				double coinflip = Math.random();
				if ((total >= 50) || (coinflip <0.5)) {/** ensures the pirate doesn't accidentally go over 50 points and
				decides randomly to roll again or not */
					F = true;
				}
			}
		}
		return total;
	}
		
	public int SnakeEyes() {
		while ((PlayerTotal < 50) && (PirateTotal < 50)) {
			int turn = PlayerTurn(PlayerTotal, PlayerHC);
			PlayerTotal += turn;
			if (PlayerTotal <50) { /* this makes sure the Pirate and Player don't reach 50 at the same time */
				turn = PirateTurn(PirateTotal);
				PirateTotal += turn;
			}	
		}
		int value = 0;
		if (PlayerTotal >= 50) {
			System.out.println("congratulations you won!");
			value = 0;
		} else if (PirateTotal >= 50) {
			value = (int)(Math.random()*100);
			System.out.println("You lost the pirates are taking " + value + " worth of goods");	
		}		
		return value;
	}
	
	public void main(String[] args) {
		playSnakeEyes TestSnake = new playSnakeEyes(25);
		int penalty = TestSnake.SnakeEyes();
		System.out.println(penalty);
	}
}

