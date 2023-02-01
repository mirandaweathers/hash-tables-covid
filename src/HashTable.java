/**
 * The HashTable class creates a hash table in the form of an
 * array of Linked Lists with states as Nodes. Functions are
 * provided for the hash function, inserting, finding, deleting,
 * and displaying states, and determining the numbers of empty
 * and collided cells in the hash table.
 * 
 * @author Miranda Weathers - N01482572
 * @version 12/5/21
 */

public class HashTable {
	
	public LinkedList[] hashArray;
	
	/**
	 * Constructor for the hash table.
	 */
	public HashTable() {
		
		hashArray = new LinkedList[101]; //new hash table, array of Linked Lists
		
		for(int i = 0; i < 101; i++) {
			hashArray[i] = new LinkedList();
		}//populate hash array with linked lists
		
	}//HashTable()

	/**
	 * Insert a State node into the linked list at the proper position
	 * in the hash table based on state name string.
	 * @param state
	 * @param population
	 * @param deaths
	 */
	public void insert(String state, long population, long deaths) {
		
		Node s = new Node(state, population, deaths);
		hashArray[hash(s.name)].add(s);
		
	}//insert()
	
	/**
	 * Search the linked list at the proper position in the hash table
	 * for the state. If found, return table index; if not, return -1.
	 * @param state
	 * @return index or -1
	 */
	public int find(String state) {
		
		int index = -1;
		
		if(hashArray[hash(state)].find(state) != null) {
			index = hash(state);
		}//if found, change index to proper value
		
		return index;
		
	}//find()
	
	/**
	 * Find and delete the given state from the hash table.
	 * @param state
	 */
	public void delete(String state) {
		
		if(find(state) == -1) {
			System.out.println(state + " is not a state.");
		} else {
			hashArray[hash(state)].remove(state);
			System.out.println(state + " was deleted.");
		}//find and delete, or indicate not found
		
	}//delete()
	
	/**
	 * Traverse the hash table and print it in a formatted sequence.
	 */
	public void display() {
		
		for(int i = 0; i < 101; i++) {
			System.out.printf("%3d.  ",i);
			if(hashArray[i].isEmpty())
				System.out.println("Empty");
			else
				hashArray[i].display();
		}//for
			
	}//display()
	
	public void printOneState(String sName) {
		
		hashArray[hash(sName)].printOne(sName);
		
	}//printOneState()
	
	/**
	 * Print the number of empty and collided cells in the hash table.
	 */
	public void printEmptyAndCollidedCells() {
		
		int e = 0;
		int c = 0;
		for(int i = 0; i < 101; i++) {
			if(hashArray[i].isEmpty())
				e++;
			if(!hashArray[i].isEmpty() && hashArray[i].hasMore())
				c++;
		}//for
		System.out.println("\n" + e + " empty and " + c + " collided cells.");
		
	}//printEmptyAndCollidedCells
	
	/**
	 * Hash function for the hash table. The sum of the integer value
	 * of the letters in the string, modulus 101.
	 * @param sName
	 * @return
	 */
	public int hash(String sName) {
		
		int index = 0;
		char[] string = sName.toCharArray();
		for(int i = 0; i < string.length; i++)
			index += string[i];
		return index % 101;
		
	}//hash()
	
}//HashTable class
