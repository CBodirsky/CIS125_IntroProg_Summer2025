/***************************************************************
* Name       : Phone
* Author      : Chris Bodirsky
* Created    : 07/14/2025
* Course     : CIS 125 - Intro to Programming
* Version     : 17.8.6
* OS            : Windows 10
* IDE           : Visual Studio 2022
* Copyright   : This is my own original work based on
*               specifications issued by our instructor
* Description : This program demonstrates a class with 
				the functions of using a phone.
*               Input:  None
*               Output: Printed messages of phone functions.
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or
* unmodified. I have not given other fellow student(s) access
* to my program.        
***************************************************************/

public class M12Phone {

	private String model;
	private String type;
	private String phoneNumber;

	public String getModel(){
		return model;
	}
	public void setModel(String model){
		this.model = model;
	}
	public String getType(){
		return type;
	}
	public void setType(String type){
		this.type = type;
	}
	public String getPhoneNumber(){
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}

	public void placeCall() {
		System.out.println("Placing a call.");
	}

	public void endCall() {
		System.out.println("Call has ended.");
	}

	public void receiveCall() {
		System.out.println("You have received a call.");
	}

	public static void main(String args[]) {
		
	}
}