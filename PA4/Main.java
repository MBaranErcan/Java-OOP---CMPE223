//-----------------------------------------------------
//Title: Main class
//Author: Bedir Esen/ Mustafa Baran Ercan
//ID: 15203509106 / 28810555206
//Section: 3 / 6 
//Assignment: 4
//Description: This class is our main class.
//-----------------------------------------------------
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//As a summary
//Firstly we read the text file and put the values in a String array. After that we created Customer objects and in suitable time periods
//we put them in our heap based priority queue. Also we created an integer array to symbolize couriers and their availability. By checking 
//different courier numbers we tried to find optimum average waiting time in our project.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        
        Scanner input = new Scanner(System.in);
       

        System.out.print("Enter input filename:");                            //We read the file with a file scanner.
        String pathname = input.nextLine();
        File file = new File(pathname);
        Scanner sc = new Scanner(file);
        
        String firstLine = sc.nextLine();
        String[] arr1 = firstLine.split(" ");
        int customerCount = Integer.parseInt(arr1[0]);                          //Firstly we are taking the first element in text file as customer number.
        
        MaxPQ pq = new MaxPQ(customerCount);                                    //And creating a priority queue in size of customer+1;
      
        Customer[] cusArr = new Customer[customerCount];                        //Creating a customer array to store customer objects.
        
        for (int i = 1; i < customerCount+1 ; i++) {
            String line = sc.nextLine();
            
            String[] arr2 = line.split("\\s+");                                 //We are taking other values from text file
            int id = Integer.valueOf(arr2[0]);
            int year = Integer.valueOf(arr2[1]);
            int orderTime = Integer.valueOf(arr2[2]);
            int travelTime = Integer.valueOf(arr2[3]);
            
            Customer customer = new Customer(id, year, orderTime, travelTime);  //And creating new customer object with this values.
            cusArr[i-1] = customer;                                             //Storing them in an customer array to insert priority queue in the next step.
        }
      
        System.out.print("\nEnter the maximum average waiting time:\n");
        double userAverageWaitingTime = input.nextDouble();
        
        int courierCount = 1;                                                   // Starting with 1 courier firstly.
        double averageWaitingTime = 0;
        boolean servicedone = false;
         
        int[] courierReturnTimeARR = new int[10];                               //Size is 10 because we are going to try with maximum 10 couriers.
        System.out.println("\nMinimum number of couriers required: " + courierCount + "\n");
        System.out.println("Simulation with " + courierCount + " couriers:\n");
        while((averageWaitingTime <= userAverageWaitingTime) && (courierCount <= customerCount)) {  //conditions are reaching max time and reaching customer number.
        	
        	
            int[] courierArr = new int[courierCount];                           //Creating  a courier array with a size of changing size in each loop.
            
            for (int i = 0; i < courierCount; i++) {                            //Assigning 1 to every courier to  them they are available. 
                courierArr[i] = 1;
            }
        
            int time = 1; 
            
            while (!servicedone && time<300) {
            	
                for (int i = 0; i < customerCount; i++) {                       // In each time period we are checking if there are orders.
                                                                                // If there is we are inserting them and rearranging our priority queue with their key values.
                    if (cusArr[i].getOrderTime() == time) {
                        pq.insert(cusArr[i]);
                    }
                }// for
               
                for (int i = 0; i < courierCount; i++) {
                    if (courierArr[i] == 1) {                                   //Checking if there is available courier to deliver order.
                        Node n =  pq.deleteMax();                                  //If there is it picks the max Node in the priority queue.
                        if(n == null) {
                    	break;
                     }
                    int waitingTime =  time-n.getCustomer().getOrderTime()+n.getCustomer().getTravelTime();  
                    System.out.println("Courier: " + (i+1) + " takes customer " + n.getCustomer().getID() +" at minute "+ time + " (wait: " + waitingTime + " mins)");
                    averageWaitingTime += waitingTime;
             
                    courierArr[i] = 0;                                          //Making value of this courier 0, indicates that this courier is not available

                    courierReturnTimeARR[i] = (time+n.getCustomer().getTravelTime()); //Time that this courier returns.
                   }
                }// for
                          
                for (int i = 0; i < courierReturnTimeARR.length; i++) {         //Loop for returning the courier. 
                                                                                //It checks whether the time is same with returning time.
                                                                                //If it is it puts 1 to courier value.
                    int x = courierReturnTimeARR[i];
                    if (x == time) {
                        for (int j = 0; j < courierCount; j++) {
                            if (courierArr[j] == 0) {
                                courierArr[j] = 1;
                 
                                courierReturnTimeARR[i] = 0;
                            }
                        }//inner for
                    }//if
                }// for
                time++; 
            }// inner while
            courierCount++;
        }//while
        System.out.println("\nAverage waiting time: " +averageWaitingTime/customerCount + " minutes");
    }
}