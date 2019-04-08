/*
 * ˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜
 * ID
 * UNIVERSIDAD ICESI (CALI-COLOMBIA)
 * DEPARTAMENTO TIC - ALGORTIMOS Y PROGRAMACIÓN I
 * SHRIMP que se duerme sofware
 * @AUTHOR: RAGNAR LODBROK <gonzalo.de1@correo.icesi.edu.co>
 * @LAST UPDATE DATE: 8 APRIL 2019
 * ˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜
 */

package ui;



import model.*;
import java.util.*;

public class  Main
{

	
//MAIN METHOD ****
	public static void main(String[] args){

		Scanner reader = new Scanner(System.in);

		

		SeaPort use = new SeaPort("Shrimp who sleeps", "Port Tura", "3100000000", "123456789");
		use.addContainer("A00358789", 20000, 'a', "This container is full of fake shoes, approved by Sgt. Lopez", false, 32);
		use.addContainer("A00338514", 23000, 'b', "This container is full of fake Gucci shirts, approved by Sgt. Lopez", true, 12);
		use.addContainer("A00340875", 25000, 't', "This container is full of fake Prada handbags, approved by Sgt. Lopez", false, 40);

		
		System.out.println("");
		System.out.println("******************************************************************************************");
		System.out.println("********** W E L C O M E  T O  S H R I M P  W H O  S L E E P S  S O F T W A R E **********");
		System.out.println("******************************************************************************************");

		int userInput = 0;

		while (userInput != 4){

			System.out.println("");
			System.out.println("1. Add a new container");
			System.out.println("2. Show containers that are leaving");
			System.out.println("3. Show how many tank containers are leaving");
			System.out.println("4. QUIT PROGRAM");
			System.out.println("");

			System.out.print("Please type the number of your selection: "); userInput = reader.nextInt(); reader.nextLine();

			switch (userInput) {

				case 1:
					System.out.print("Please type the new container's ID: "); String id = reader.nextLine();
					System.out.print("Please type the new container's weight: "); double weight = reader.nextDouble(); reader.nextLine();
					System.out.println("");
					System.out.println("Select the new container's type: "); 
					System.out.println("1. Dry van 20' ");
					System.out.println("2. Dry van 40' ");
					System.out.println("3. Tank");
					System.out.print("Please type the number of your selection: "); int selection1 = reader.nextInt(); reader.nextLine();

					

					if(selection1 == 1 || selection1 == 2 || selection1 == 3){
						char type = 'x';

						switch (selection1) {
							case 1: type = 'a';
								break;
							case 2: type = 'b';
								break;	
							case 3: type = 't';
								break;			
						}

						System.out.println("");
						System.out.println("Has the container left already?");
						System.out.println("1. Yes");
						System.out.println("2. No"); 
						System.out.print("Please type the number of your selection: "); int selection = reader.nextInt(); reader.nextLine();

						if(selection == 1 || selection == 2){
							boolean arriving = true;

							switch (selection) {
								case 1: arriving = false;
									break;		
							}

							System.out.print("Please type the new container's description: "); String description = reader.nextLine();
							System.out.print("Please type how many days the new container has stayed in the dock: "); int days = reader.nextInt(); reader.nextLine();
							use.addContainer(id, weight, type, description, arriving, days);
								
						
						} else{System.out.println("ERROR: Invalid selection");}			

					} else{System.out.println("ERROR: Invalid selection");}



					

					break;
				case 2: 
					int ind = 0;
					ArrayList<Container> containersList = use.getOutputContainers();

					System.out.println("");
					for (int i = 0; i < containersList.size() ; i++ ) {
						++ind;
						System.out.println(ind+ ". " +containersList.get(i).getId());
						
					}
					break;
				case 3: 
					System.out.println("");
					System.out.println("Number of tank containers that are leaving: "+use.requestTankContainerAmount());
					System.out.println("");
					break;
				case 4:
					break;
				default: System.out.println("ERROR: Invalid selection");
					break;
				
				
			}

		}	
	
	}	

} //final