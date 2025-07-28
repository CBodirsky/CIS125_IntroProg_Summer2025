import java.util.Scanner;

public class M8MilesToLaps {
    static final double LAP_LENGTH= 0.25;
    static double totalMiles;
    static double numberOfLaps;

    public static void main(String[] args)
    {
        
        

        Scanner input = new Scanner(System.in);

        System.out.print("How many miles do you want to walk? ");
        totalMiles = input.nextDouble();
        input.close();
        System.out.println("Your number of laps needed is " + milesToLaps(totalMiles));
    }

    public static double milesToLaps(double totalMiles)
    {
        numberOfLaps = Math.ceil(totalMiles / LAP_LENGTH);
        return numberOfLaps;
    }
}
/* I moved variables to outside of the methods and into the
class itself instead of inside the main method so they could
be used across the whole program. Having to use static on each
variable was a surprise and I had to reflect on what that does
 to these variables.
 */