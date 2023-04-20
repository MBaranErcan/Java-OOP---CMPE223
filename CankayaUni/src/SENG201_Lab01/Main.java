package SENG201_Lab01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Flight flight = new Flight("0001");
   /*     flight.reserveSeat("Ogulcan");
        flight.reserveSeat("Baran");
        flight.reserveSeat("Duru");
        flight.reserveSeat("Hasan");
        flight.reserveSeat("Oyku");
        flight.reserveSeat("Baris");
        flight.cancelReservation("Hasan");
        flight.reserveSeat("Fatos");
       
        flight.cancelReservation("Baris");
        flight.printNumOfPassengers();
        flight.printPassengers();
    */    
        menu(flight);    
    }
    
    public static void menu(Flight flight){
        System.out.println("                 WELCOME");
        int action = 0;
        while (action != 5) {
            
            System.out.print("\n-------------------menu--------------------" +
                            "\nYou are currently acting on Flight " + flight.printFlightNO() +
                            "\n1- Reserve a ticket" + 
                            "\n2- Cancel a reservation" + 
                            "\n3- Check your Ticket" + 
                            "\n4- Display flight no and passengers" +
                            "\n5- Exit" +
                            "\nYour choice: ");
                            
        
            Scanner scan = new Scanner(System.in);
            action = scan.nextInt();

            switch (action) {
                case 1:
                    System.out.print("Name: ");
                    flight.reserveSeat(scan.next());
                    System.out.println("Turning back to menu");
                    break;
                case 2:
                    System.out.print("Name: ");
                    flight.cancelReservation(scan.next());
                    System.out.println("Turning back to menu");
                    break;
                case 3:
                    System.out.print("Name: ");
                    if (flight.listOfPassengers.contains(scan.next())) {
                        System.out.println("Does have a ticket");
                    }else {
                        System.out.println("Does NOT have a ticket!");
                    }
                    System.out.println("Turning back to menu");
                    break;
                case 4:
                    System.out.println("Flight NO: " + flight.printFlightNO());
                    flight.printPassengers();
                    break;
                case 5:
                    System.out.println("GOODBYE...");
                    break;
                default:
                    System.out.println("Incorrect Choice!!!");
                    System.out.println("Turning back to menu");
                }
        }
              
    }
    
}
