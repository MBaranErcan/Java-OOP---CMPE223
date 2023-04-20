//-----------------------------------------------------
//Title: Node class
//Author: Bedir Esen/ Mustafa Baran Ercan
//ID: 15203509106 / 28810555206
//Section: 3 / 6 
//Assignment: 4
//Description: This class is our own Node implementation. 
//-----------------------------------------------------

//We wanted to use Nodes in our binary heap because we needed to access key value and other Customer object values.
//So, we used Nodes that stores a customer.
public class Node {
 
	private int yearWithCompany;         
	private int ID;
	private Customer customer;
	
	
	public Node(Customer customer) {
		yearWithCompany = customer.getYearWithCompany();    //Node constructor
		ID = customer.getID();
		this.customer  = customer;
	}

	public int getYearWithCompany() {  //All of getter and setters.
		return yearWithCompany;
	}

	public void setYearWithCompany(int yearWithCompany) {
		this.yearWithCompany = yearWithCompany;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}