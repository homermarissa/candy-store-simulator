import java.io.*;
import java.util.Scanner;

public class MarissaMainFinalProject {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Scanner keyboard = new Scanner(System.in);
		
		//This array will hold the number of each candies the user wants to buy
		//The first place will hold the number for Starbursts, the second for Skittles, and the third for Gummy worms
		int[] numberOfCandyList = new int[3];
		
		//initializing the variables
		int userChoice = 0;
		double candyCost = 0;
		
		
		System.out.println("Hello! Welcome to Marissa's Candy Store! Its time to buy some candy!");
		System.out.println("Today, we have Starburts, Skittles, and Gummy Worms for sale! Here is our menu.");
		System.out.println("Please choose a number from the menu!");
		System.out.println("");
		
		//creating the objects
		Starbursts starbursts = new Starbursts();
		Skittles skittles = new Skittles();
		GummyWorms gummyworms = new GummyWorms();
		
		//The menu will keep displaying until the user chooses to exit
		do {
			menuDisplay();
			
			//asking the user for a choice
			userChoice = keyboard.nextInt();
			
			switch(userChoice) {
			case 1:
				//Displays info about each type of candy
				starbursts.displayInfo();
				System.out.println("");
				skittles.displayInfo();
				System.out.println("");
				gummyworms.displayInfo();
				System.out.println("");
				
				break;
			case 2:
				//Adding Starbursts to cart and updating cost
				System.out.println("You added Starbursts to your cart!");
				System.out.println("");
				numberOfCandyList[0] = numberOfCandyList[0] + 1;
				candyCost = candyCost + 2.0;
				break;
			case 3:
				//Adding Skittles to cart and updating cost
				System.out.println("You added Skittles to your cart!");
				System.out.println("");
				numberOfCandyList[1] = numberOfCandyList[1] + 1;
				candyCost = candyCost + 1.5;
				break;
			case 4:
				//Adding Gummy Worms to cart and updating cost
				System.out.println("You added Gummy Worms to your cart!");
				System.out.println("");
				numberOfCandyList[2] = numberOfCandyList[2] + 1;
				candyCost = candyCost + 1.75;
				break;
			case 5:
				//exiting
				System.out.println("You have chosen to exit.");
				break;
			default:
				System.out.println("Please choose a valid number.");
				break;
			}
			
			} while (userChoice != 5);
			
		//Printing out the number of candies the user chose for each type of candy
		System.out.println("You have chosen these amounts of candies in order of Starbursts, Skittles, then Gummy Worms");
		for (int i = 0; i < numberOfCandyList.length; i++) {
			System.out.println(numberOfCandyList[i]);
		}
		//adding the amounts of the candies the user chose to add to their cart
		int totalAmountOfCandy = (numberOfCandyList[0] + numberOfCandyList[1] + numberOfCandyList[2]);
		System.out.println("Your total amount of candies: " + totalAmountOfCandy);
		
		//if and if/else statements that print out different messages based on how many candies they added to their cart
		if (totalAmountOfCandy == 0){
			System.out.println("Wow you didn't want any candy?? Alrighty then.");
		}
		
		if (totalAmountOfCandy > 0 && totalAmountOfCandy <= 10) {
			System.out.println(totalAmountOfCandy + " seems like a reasonable amount of candy/candies.");
			
		}
		else if (totalAmountOfCandy > 10){
			System.out.println("Thats a lot of candy!");
		}
		
		//Printing out the final cost of the candies
		System.out.println("Your total is: $" + candyCost);
		
		System.out.println("A receipt will be made. It will appear on the desktop and will be called 'Marissa'sCandyStoreReceipt'");
		//CREATING A FILE TO GIVE THE USER A RECEIPT
		// Checks to see if file exists, if it doesn't, then it creates it
		// Stored on our Desktop
		//false means that it over writes the file
		FileWriter fw = new FileWriter("/Users/marissahomer/Desktop/Marissa'sCandyStoreReceipt.txt", false);
		//Gives print method to our file
		PrintWriter outputFile = new PrintWriter(fw);
		outputFile.println("===RECEIPT===");
		outputFile.println("Your total amount of candies: " + totalAmountOfCandy);
		outputFile.println("Your total is: $" + candyCost);
		outputFile.close(); 
		
		
	}
	
		//Creating the menu
		public static void menuDisplay() {
			System.out.println("===MENU===");
			System.out.println("1.) Disply info about candy");
			System.out.println("2.) Add Starbursts to your cart");
			System.out.println("3.) Add Skittles to your cart");
			System.out.println("4.) Add Gummy Worms to your cart");
			System.out.println("5.) EXIT");
		}
}
