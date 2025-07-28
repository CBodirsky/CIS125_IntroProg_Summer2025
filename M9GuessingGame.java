import java.util.Scanner;

public class M9GuessingGame
{
	public static void main(String[] args)
	{
		GetNumber();
	}
	public static void GetNumber()
	{
		Scanner scanner = new Scanner(System.in);
		int attempts = 0;
		int guessedNum = 0;
		int correctNum = (int)(Math.random() * 10)+1;
		while (guessedNum != correctNum)
		{
			System.out.println("Please guess a number between 1 and 10! ");
			attempts++;
			guessedNum = scanner.nextInt();

			if (guessedNum < correctNum)
			{
				System.out.println("Your guess is too low!");

			}
			else if (guessedNum > correctNum)
			{
				System.out.println("Your guess is too high!");
			}
			else
			{
				System.out.println("The number " + guessedNum + " is correct! You took " + attempts + " tries!");
			}
		}
	scanner.close();
	}
}