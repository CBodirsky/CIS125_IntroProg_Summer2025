/***************************************************************
* Name       : Dog Search
* Author      : Chris Bodirsky
* Created    : 07/07/2025
* Course     : CIS 125 - Intro to Programming
* Version     : 17.8.6
* OS            : Windows 10
* IDE           : Visual Studio 2022
* Copyright   : This is my own original work based on
*               specifications issued by our instructor
* Description : This program lists dogs and their sizes,
				propmts about a dog and gives breed.
*               Input:  Dog name
*               Output: That dog's breed
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or
* unmodified. I have not given other fellow student(s) access
* to my program.        
***************************************************************/

import java.util.Scanner;

public class M10DogSearch
{
	private static int linearSearch(String[] array, String value) {
		for(int i = 0; i < array.length; i++) {
			if (array[i].equalsIgnoreCase(value)) {
				return i;
			}
		}
		return -1;
	}

	private static void dogSizes(String[] names, double[] weight) {
		for (int i = 0; i < names.length; i++) {
			String size;
			if (weight[i] <= 20) {
				size = "Small breed";
			}
			else  {
				size = "Large breed";
			}
			//Print all the dogs and their size
			System.out.println(names[i] + ": " + size);
		}
	}
	
	public static void main(String args[]) {
	Scanner dogScan = new Scanner(System.in);
	//dog list
	String [] names = {"Copper",  "Fido", "Dino", "Sebastian", "Blackie", "Cuddles"};
	String [] breeds = {"German Shepherd", "German Shepherd", "Terrier", "Chihuahua", "Black Lab", "Terrier"};
	double [] weight = {98.4, 87.8, 17.4, 4.3, 78.4, 15.2};

	dogSizes(names, weight); 

	//Input string
	System.out.println ("Enter your dog's name.");
	String dogSearch = dogScan.nextLine();
	dogScan.close();

	int foundDog = linearSearch(names, dogSearch);
	if (foundDog != -1) 
	{
		String breed = breeds[foundDog];
		System.out.println("Your dog's breed is " + breed);
	}
	else
	{
		System.out.println("Dog not found!");
	}

	}
}
