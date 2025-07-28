/***************************************************************
* Name       : CyberSecurityApp
* Author      : Chris Bodirsky
* Created    : 06/25/2025
* Course     : CIS 125 - Intro to Prog. Logic [30122]
* Version     : zyBook IDE
* OS            : Windows 10
* IDE           : zyBook IDE
* Copyright   : This is my own original work based on
*               specifications issued by our instructor
* Description : This program demonstrates methods with an alert
*               Input:  None
*               Output: Printed messages
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or
* unmodified. I have not given other fellow student(s) access
* to my program.        
***************************************************************/


public class M8CyberSecurityApp {
    public static void main(String[] args) {
        displayAlert();
        displayTip();
    }

    public static void displayAlert()
    {
        System.out.println("ALERT: Suspicious login attempt detected!");
    }

    public static void displayTip()
    {
        System.out.println("TIP: Always use strong and unique passwords for each account.");
    }

}

