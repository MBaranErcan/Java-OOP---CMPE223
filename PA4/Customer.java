//-----------------------------------------------------
//Title: Customer class
//Author: Bedir Esen/ Mustafa Baran Ercan
//ID: 15203509106 / 28810555206
//Section: 3 / 6 
//Assignment: 4
//Description: This class is our customer blueprint class.
//-----------------------------------------------------

//We have variables: ID, yearWithCompany, orderTime and travelTime.

public class Customer {
    private int ID;                               
    private int yearWithCompany;                                                // 2022 - year
    private int orderTime;
    private int travelTime;

    public Customer(int ID, int year, int orderTime, int travelTime) {          // Customer constructor.
        this.ID = ID;
        this.yearWithCompany = 2022 - year;
        this.orderTime = orderTime;
        this.travelTime = travelTime;
    }

    public int getID() {                                                        //All of the belows are getters and setters.
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getYearWithCompany() {
        return yearWithCompany;
    }

    public void setYearWithCompany(int year) {
        this.yearWithCompany = 2022 - year;
    }

    public int getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(int orderTime) {
        this.orderTime = orderTime;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }
    
}