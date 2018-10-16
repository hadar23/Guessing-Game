
import javax.swing.JOptionPane;
import java.util.Random;

public class Guessing_Game {
	public static void main(String[] args) {
		int option1 = 0;

		while (option1 == JOptionPane.YES_OPTION) // loop of the game
		{
			String name1 = JOptionPane.showInputDialog("Please enter the name of player 1: "); // the first name
			String name2 = JOptionPane.showInputDialog("Please enter the name of player 2: "); // the second name
			Random rand = new Random(); // random number by the computer
			int num1 = 0, num2 = 0, num3 = 0;
			while (num1 == num2 || num1 == num3 || num2 == num3) // check the numbers are good
			{
				num1 = rand.nextInt(5) + 1;
				num2 = rand.nextInt(5) + 1;
				num3 = rand.nextInt(5) + 1;
			}
			boolean b = true;// getting numbers, checking and printing the secret numbers
			while (b) {
				String number = JOptionPane
						.showInputDialog("For practice:\nHow many secret numbers do you want to show?\n"
								+ "press 1,2,3 or cancel for none");
				if (number == null) {
					b = false;
					break;
				}
				switch (number) // printing the secret numbers
				{
				case "1":
					System.out.println("The secret number is " + num1);
					b = false;
					break;
				case "2":
					System.out.println("The secret numbers are " + num1 + " " + num2);
					b = false;
					break;
				case "3":
					System.out.println("The secret numbers are " + num1 + " " + num2 + " " + num3);
					b = false;
					break;
				default:
					JOptionPane.showMessageDialog(null, "Choose 1, 2, 3 or press cancel");
				}
			}
			String guess = null;
			int guess1 = 0, guess2 = 0, guess3 = 0, game1 = 1;
			String nameplay;
			while ((game1 == 1) || (game1 == 2)) // loop of the game by players till we have a winner.
			{
				if (game1 == 1) // this "if" change the values of the players names
					nameplay = name1;
				else
					nameplay = name2;
				int i = 1;
				while (i != 4) // loop of the guess, till we have 3 guess per player
				{
					guess = JOptionPane
							.showInputDialog("Player " + game1 + " " + nameplay + "\nPlease enter gusse number " + i);
					if (i == 1) // the first guess
						guess1 = Integer.parseInt(guess);
					if (i == 2) // the second guess
					{
						guess2 = Integer.parseInt(guess);
						while (guess2 == guess1) // check that the player didnt choose the same guess
						{
							guess2 = Integer.parseInt(JOptionPane.showInputDialog("Player " + game1 + " " + nameplay
									+ "\nPlease don't guess the same numbers\nPlease enter gusse number " + i));
						}
					}
					if (i == 3) // the third guess
					{
						guess3 = Integer.parseInt(guess);
						while ((guess3 == guess1) || (guess3 == guess2)) // check that the player didnt choose the same
																			// guess
						{
							guess3 = Integer.parseInt(JOptionPane.showInputDialog("Player " + game1 + " " + nameplay
									+ "\nPlease don't guess the same numbers\nPlease enter gusse number " + i));
						}
					}
					i++;
				}
				int numberofguess = 0; // check how much he guess good
				if ((guess1 == num1) || (guess1 == num2) || (guess1 == num3))
					numberofguess++;
				if ((guess2 == num1) || (guess2 == num2) || (guess2 == num3))
					numberofguess++;
				if ((guess3 == num1) || (guess3 == num2) || (guess3 == num3))
					numberofguess++;
				if (numberofguess == 3) // response a message if he won
				{
					option1 = JOptionPane.showConfirmDialog(null, "congratulations!\nPlayer " + game1 + " " + name1
							+ " won!\nDo you want to start a new game?");
					game1 = 3;
				}
				if (numberofguess < 3) // if we dont have a winner ,printing a massage and fixing all the values and
				{
					JOptionPane.showMessageDialog(null, numberofguess + " numbers were guessed correctly", null,
							JOptionPane.INFORMATION_MESSAGE);
					if (game1 == 2) {

						game1 = 0;

					}
					game1++;
				}
			}
		}
		JOptionPane.showMessageDialog(null, "The game is over");
	}
}
