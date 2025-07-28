

import java.util.Random;
import java.util.Scanner;

/**
 * Avatar starter Code created by Karen O'Loughlin
 */
public class M9Avatar {
	
	
	public static int getAvatarChoice(Scanner scnr) {
		int avatarType = 0;

		System.out.println("Enter your choice of Avatar");
		System.out.println("1. Warrior");
		System.out.println("2. Mage");
		avatarType = scnr.nextInt();
		scnr.nextLine();
		return avatarType;
		//I wanted to change this to include typing "warrior" and "mage" strings,
		//but it's part of our default template, so I'll leave it be. But I could!
	}

	public static String getMagicType(Scanner scnr)
	{
		System.out.println("What magic do you wield?\n1. Fire\n2. Ice\n3. Earth");
    	String choice = scnr.nextLine().trim().toLowerCase();
		switch(choice) {
			case "1":
			return "fire";
			case "2":
			return "ice";
			case "3":
			return "earth";
			case "fire":
			case "ice":
			case "earth":
			return choice;
			default: return "invalid";
		}
	}

	public static int setPowerLevel(String magicType, Random random)
	{
		int powerLevel;

		switch (magicType) {
			case "fire":
				// Generate the range total (max - min) and add the minimum
				powerLevel = random.nextInt(51) + 50;
				break;
			case "ice":
			case "earth":
				powerLevel = random.nextInt(51) + 20;
				break;
			default:
				powerLevel = 0;
				break;
		}
		return powerLevel;
	}
	public static void main(String[] args) {
		
		System.out.println("Welcome to Avatar Wars");

		Random random = new Random();
		Scanner scnr = new Scanner(System.in);
		int avatarChoice = getAvatarChoice(scnr);
		int powerLevel;

        switch (avatarChoice) {
			case 1: 
				//10 gives a range of 0 to 9. +1 creates a minimum of 1 and range to 10
				int strength = random.nextInt(10) + 1;
				int defense = random.nextInt(10) + 1;
				if (strength > 7 && defense > 7 )
				{
					System.out.println("You are Jedi trained.");
				}
				else if (strength > 5 && defense > 5)
				{
					System.out.println("You are quite capable and eligible to join the Jedi training.");
				}
				else
				{
					System.out.println("You are a NOVICE. Keep training.");
				}
				break;
			case 2:
				String magicType = getMagicType(scnr);
				powerLevel = setPowerLevel(magicType, random);
				if (magicType.equals("invalid"))
				{
					System.out.println("The force isn't with you.");
					break;
				}
				System.out.println("Your power level for " + magicType + " is " + powerLevel + " kilodyne.");

				break;
			default:
				System.out.println("Get out of here nerf herder!");
			}
		
		scnr.close();
	}
}