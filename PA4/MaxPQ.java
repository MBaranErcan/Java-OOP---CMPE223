//-----------------------------------------------------
//Title: MaxPQ class
//Author: Bedir Esen/ Mustafa Baran Ercan
//ID: 15203509106 / 28810555206
//Section: 3 / 6 
//Assignment: 4
//Description: This class is our heap based priority queue class.
//-----------------------------------------------------

public class MaxPQ {  //In our binary heap structure, we used Node based heap to store Customer beside our key value year.                  

	private Node[] heap;                                                    //We used nodes in our heap but our key value is getYearWithCompany. 
                                                                                //We insert nodes by checking getYearWithCompany value.
	int n;
	
	
	public MaxPQ(int capacity) {
		heap = new Node[capacity+1];                                    //+1 because the first index must be null.
		n =0;
	}
	
	public boolean isEmpty() {
		return n == 0;
	}
	
	public void insert(Customer c) {                                        //We override the insert method with Customer paramater to insert customer to our heap.
		Node node = new Node(c);
		insert(node);
	}
	
	public void insert(Node x) {                                            //Rest of this class is same with integer key valued heaps. The only differences we used Node in our heap rather than int.
		n++;
		heap[n] = x;
		swim(n);
		
	}

	private void swim(int k) {                                              //In the insert method, it inserts to end of the heap. Swim method compares the key values of
                                                                                //the nodes and swaps them if the child Node's key value is greater than parent.
	
		while(k>1 && heap[k/2].getYearWithCompany()<heap[k].getYearWithCompany()) {
			
			Node temp = heap[k];
			heap[k]= heap[k/2];
			heap[k/2]= (temp);
			k = k/2;
		}
		
	}

	
	public void printMaxHeap() {                                            //Printing getYearWithCompany values of our nodes.
		for(int i =1; i<=n; i++) {
			System.out.print(heap[i].getYearWithCompany()+" ");
		}
	}
	
	public Node deleteMax() {                                               //This method deletes and returns the max of the priority queue. It uses swap and sink methods.
                                                                                //Also it takes the min value to top and uses sink method to rearrange the priority queue.
		if (n<1) return null;
         
		Node max = heap[1];
         swap(1,n);
 		 n--;
 		 sink(1);
 		 heap[n+1] =null;
 		 
 		 return max;
	}
	
	private void sink(int k) {                                              //This method compares the parent with child and swaps them in the correct positions.
		
		while(2*k<=n) {
			int j = 2*k;
			if(j<n && heap[j].getYearWithCompany()<heap[j+1].getYearWithCompany()) {
				j++;
			}
			if(heap[k].getYearWithCompany()>=heap[j].getYearWithCompany()) {
				break;
			}
			swap(k,j);
			k=j;
		}		
	}
	
	public void swap(int a, int b) {                                        // swap method to change two nodes.
		Node temp = heap[a];
		heap[a] = heap[b];
		heap[b] = temp;
	}
     
}