/***************************************************************
* Name       : BankApp
* Author      : Chris Bodirsky
* Created    : 06/25/2025
* Course     : CIS 125 - Intro to Prog. Logic [30122]
* Version     : zyBook IDE
* OS            : Windows 10
* IDE           : zyBook IDE
* Copyright   : This is my own original work based on
*               specifications issued by our instructor
* Description : This program demonstrates method arguments with a bank app simulation
*               Input:  None
*               Output: Printed messages
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or
* unmodified. I have not given other fellow student(s) access
* to my program.        
***************************************************************/


public class M8BankApp {
    public static void main(String[] args) 
    {
        displayAccountDetails("John Doe", 500.00);
        processWithdrawal(500.00, 200.00);
        processWithdrawal(500.00, 600.00);
    }

    public static void displayAccountDetails(String accountName, double accountBalance)
    {
        System.out.printf("Account Name: " + accountName + " Current Balance: $%.2f%n", accountBalance);
    }

    public static void processWithdrawal(double accountBalance, double withdrawalAmount)
    {
        if (withdrawalAmount <= accountBalance)
        {
            double remainingBalance = accountBalance - withdrawalAmount;
            System.out.printf("Withdrawal of $%.2f successful. Remaining balance: $%.2f%n", withdrawalAmount, remainingBalance);
        }
        else
        {
            System.out.printf("Insufficient funds! Your current balance is $%.2f%n", accountBalance);
        }
    }

}

