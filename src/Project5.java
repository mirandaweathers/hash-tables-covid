import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * COP 3530: Project 5 - Hash Tables
 * <p>
 * Project 5 demonstrates the use of a hash table using separate
 * chaining to handle collisions. A comma-separated file is provided
 * by the user and parsed for each state's name, population, and
 * number of COVID deaths which are all provided to the hash table
 * to be stored as nodes in the appropriate hash cell's linked list.
 * <p>
 * The hash function for determining the index of a given state is
 * the sum of the sum of the Unicode values of all the characters in
 * the state name modulus 101, the size of the hash array.
 * <p>
 * Once the hash array is populated with the initial file contents,
 * the user is presented with a menu of options: Print the hash table;
 * Delete a state; Insert a state; Print a single state's name and
 * death rate; Print numbers of empty and collided cells; and Exit.
 * The menu is given repetitively until the user chooses to exit.
 * 
 * @author Miranda Weathers - N01482572
 * @version 12/5/21
 */

public class Project5 {

	public static void main(String[] args) {
		
		//prompt for file
		System.out.print("Enter the file name: ");
		Scanner scan = new Scanner(System.in);
		String fileName = scan.nextLine();
		
		//check if file exists
		Scanner readFile = null;
		try {
			readFile = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("\nFile not found.");
			System.exit(1);
		}//try-catch
		
		//create hash table & state variables
		HashTable h = new HashTable();
		String name;
		int population;
		int deaths;
		
		//read in file
		readFile.nextLine(); //skip labels
		readFile.useDelimiter(",|\n"); //delimiters: , and \n
		while(readFile.hasNext()) {
			name = readFile.next();
			readFile.next();
			readFile.next();
			readFile.next();
			population = readFile.nextInt();
			readFile.next();
			deaths = readFile.nextInt();
			readFile.next();
			readFile.next();
			h.insert(name, population, deaths);
		}//create states and populate hash table
		
		//present menu
		boolean flag = true;
		int choice = 0; //menu choice
		String search = null; //for option 5
		
		while(flag==true) {
			System.out.println("\n1) Print hash table");
			System.out.println("2) Delete a state of a given name");
			System.out.println("3) Insert a state of a given name");
			System.out.println("4) Search and print a state and its DR for a given name");
			System.out.println("5) Print numbers of empty and collided cells");
			System.out.println("6) Exit");
			System.out.print("\nEnter the number of your choice: ");
			
			//check if input matches type int
			if(scan.hasNextInt()) {
				choice = scan.nextInt();
				scan.nextLine();
			} else {
				System.out.println("\nPlease enter an integer between 1-8.");
				scan.nextLine();
				continue;
			}//end if else
		
			switch(choice) {
			case 1: //print hash table
				h.display();
				break;
			case 2: //delete state
				System.out.print("\nState name: ");
				search = scan.nextLine();
				search = search.replaceAll("\\n", "");
				h.delete(search);
				break;
			case 3: //insert state
				System.out.print("\nState name: ");
				name = scan.nextLine();
				name = name.replaceAll("\\n", "");
				System.out.print("Population: ");
				if(scan.hasNextInt()) {
					population = scan.nextInt();
				} else {
					System.out.println("Enter an integer.");
					continue;
				}//if-else
				scan.nextLine();
				System.out.print("COVID Deaths: ");
				if(scan.hasNextInt()) {
					deaths = scan.nextInt();
				} else {
					System.out.println("Enter an integer.");
					continue;
				}//if-else
				scan.nextLine();
				h.insert(name, population, deaths);
				System.out.println(name + " was inserted.");
				break;
			case 4: //search for state and print DR
				System.out.print("\nState name: ");
				search = scan.nextLine();
				search = search.replaceAll("\\n", "");
				if(h.find(search)!=-1) {
					h.printOneState(search);
				} else {
					System.out.println(search + " not found.");
				}//if-else
				break;
			case 5: //print numbers of empty and collided cells
				h.printEmptyAndCollidedCells();
				break;
			case 6: //exit
				System.out.println("\nGoodbye!");
				flag=false;
				break;
			default:
				System.out.println("Select a valid option.");
				break;
			}//switch
			
		}//menu loop
		
		scan.close();

	}//main()

}//Project5 class
