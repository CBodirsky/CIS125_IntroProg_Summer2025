import java.util.Scanner;

public class M9InputValidation
{
	public static void main(String[] arg)
	{
		Scanner pinScan = new Scanner(System.in);
		final int PIN = 1234;
		int pinAttempt = 0;

		System.out.println("Please provide the PIN: ");
		while (pinAttempt != PIN)
		{
			pinAttempt = pinScan.nextInt();
			if (pinAttempt != PIN)
			{
				System.out.println("That number is not valid. Please re-enter your PIN: ");
			}
			else
			{
				System.out.println("PIN confirmed! You now have access to your account!");
			}
		}
		pinScan.close();
	}
}