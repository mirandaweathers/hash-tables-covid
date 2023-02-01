/**
 * The LinkedList class handles separate chaining for each hash
 * table cell. Insertion, deletion, search, and display are all
 * available through this class, as well as two boolean functions
 * to determine if a chain is empty or if it has multiple items.
 * 
 * @author Miranda Weathers - N01482572
 * @version 12/5/21
 */

public class LinkedList {
	
	private Node first;
	private Node last;
	
	/**
	 * Constructor for a linked list.
	 */
	public LinkedList() {
		first = null;
		last = null;
	}//LinkedList()
	
	/**
	 * Insert state node at end of double-ended singly-linked list.
	 * @param n
	 */
	public void add(Node n) {
		
		if(first==null) {
			first = n;
		} else {
			last.nextNode = n;
		}//if empty or not
		
		last = n;
		
	}//insert()
	
	/**
	 * Display the entire linked list.
	 */
	public void display() {
		
		Node current = first;
		
		while(current!=null) {
			current.printNode();
			if(current!=null && current.nextNode!=null)
				System.out.print("      ");
			current = current.nextNode;
			
		}//while
		
	}//display()
	
	/**
	 * Search for a state in the hash table.
	 * @param sName
	 * @return state Node if found; null if not
	 */
	public Node find(String sName) {
		
		Node current = first;
		while(current!=null) {
			if(sName.compareToIgnoreCase(current.name) == 0) 
				return current;
			current = current.nextNode;
		}//while
		return null; //if not found
		
	}//find()
	/**
	 * Print a single state's name and death rate.
	 * @param sName
	 */
	public void printOne(String sName) {
		
		Node current = first;
		while(current!=null) {
			if(sName.compareToIgnoreCase(current.name) == 0) 
				current.printNode();
			current = current.nextNode;
		}//while
		
	}//printOne()
	
	/**
	 * Remove state node from list based on given name.
	 */
	public void remove(String sName) {
		
		Node previous = null;
		Node current = first;
		
		while(current != null && sName.compareToIgnoreCase(current.name) != 0) {
			previous = current;
			current = current.nextNode;
		}//move along list to find state
		
		if(previous==null) //remove first node
			first = first.nextNode;
		else //non-first node
			previous.nextNode = current.nextNode;
		
	}//remove()
	
	/**
	 * Determine whether linked list is empty or not.
	 * @return true if null; false if not
	 */
	public boolean isEmpty() {
		return first == null;
	}//isEmpty
	
	/**
	 * Determine whether cell has more than one node. (collision)
	 * @return true if collided; false if not
	 */
	public boolean hasMore() {
		return first.nextNode != null;
	}//hasMore()
	
}//LinkedList class
