/***************************************************************
* Name       : Threat Analyzer
* Author      : Chris Bodirsky
* Created    : 07/07/2025
* Course     : CIS 125 - Intro to Programming
* Version     : 17.8.6
* OS            : Windows 10
* IDE           : Visual Studio 2022
* Copyright   : This is my own original work based on
*               specifications issued by our instructor
* Description : This program receives threat levels and
				sorts them in order.
*               Input:  Integer valuees
*               Output: Sorted integer values
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or
* unmodified. I have not given other fellow student(s) access
* to my program.        
***************************************************************/

import java.util.Scanner;
import java.util.Arrays;

public class M10ThreatAnalyzer {

	public static void sortThreatLevels(int[] threats) {
		Arrays.sort(threats);
	}

	public static void printThreats(int[] threats) {
		for (int i = 0; i < threats.length; i++) {
			System.out.println(threats[i] + ": " + displayThreatDescriptions(threats[i]));
		}
		System.out.println();
	}

	public static String displayThreatDescriptions(int level) {
		if (level == 1) {
			return "Low Threat: Monitor activity";
		}
		else if (level == 2 || level == 3) {
			return "Medium Threat: Investigate further.";
		}
		else if (level == 4 || level == 5) {
			return "High Threat: Take immediate action.";
		}
		else
		{
			return "Unknown threat level.";
		}
	}

	public static void main(String args[]) {
		Scanner threatScan = new Scanner(System.in);
		int [] threatLevels = new int[3];
	//get each value
		System.out.println("Enter 3 threat levels (1 = low, 5 = high): ");
		for (int i = 0; i < threatLevels.length; i++) {
			threatLevels[i] = threatScan.nextInt();
		}
		sortThreatLevels(threatLevels);
		printThreats(threatLevels);
		threatScan.close();
	}
}