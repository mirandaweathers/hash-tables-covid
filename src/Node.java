/**
 * Each state is stored as a node with name, population, deaths,
 * and a reference to the next node.
 * @author Miranda Weathers - N01482572
 * @version 12/5/21
 */

public class Node {
			
	String name;
	long population;
	long deaths;
	Node nextNode;
	
	public Node(String name, long population, long deaths) {
		this.name = name;
		this.population = population;
		this.deaths = deaths;
	}//Node() constructor
	
	public void printNode() {
		System.out.printf("%-30s %-20.2f\n", name,
		(double)deaths/population*100000);
	}//printNode()
	
}//Node class
