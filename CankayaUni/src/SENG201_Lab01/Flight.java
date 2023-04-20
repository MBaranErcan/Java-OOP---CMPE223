package SENG201_Lab01;

import java.util.ArrayList;
import java.util.Collections;

public class Flight {
    
    private String flightNO;
    private final int maxSeats = 25;
    private int numOfPassengers;
    ArrayList<String> listOfPassengers = new ArrayList<>();

    public Flight(String flightNO) {
        this.flightNO = flightNO;
    }
    
    public boolean reserveSeat(String name) {
        if (numOfPassengers == 25) {    //checks if flight is full
            System.out.println("Flight is Full!!");
            return false;
        }
        else {
//            Passenger passenger = new Passenger(name);
            listOfPassengers.add(name);
            numOfPassengers++;
            System.out.println("Passenger " + name + " has successfully reserved a seat");
            return true;
        }
    }
    
    public boolean cancelReservation(String name) {
        if (numOfPassengers > 0) {  //checks if flight is empty
            if (listOfPassengers.contains(name)) {            
                listOfPassengers.remove(name);
                numOfPassengers--;
                System.out.println("Passenger " + name + " has successfully cancelled a reservation!");
                return true;
            }else {
                System.out.println("Name not found!!!");
                return false;
            }
            
        }else {
            System.out.println("Flight is already empty!!!");
            return false;
        }
    }
    
    public int printNumOfPassengers() {
        return numOfPassengers;
    }
    
    public String printFlightNO() {
        return(flightNO);
    }
    
    public void printPassengers() {
        if (numOfPassengers == 0)
            System.out.println("There are no passengers!");
        else {
        ArrayList<String> temp = new ArrayList<>(numOfPassengers);
        temp = (ArrayList)listOfPassengers.clone();
        Collections.sort(temp);
        System.out.println("There are " + printNumOfPassengers() + " passengers on the Flight " + printFlightNO() + ": " + temp);
        }
    }    
}
