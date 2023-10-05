//-----------------------------------------------------
// Title: Main class
// Author: Mustafa Baran Ercan
// ID: 28810555206
// Section: 6
// Assignment: 2
// Description: This class is main class. It also includes methods to sort the array with desired algorithm.
//-----------------------------------------------------
import java.util.Random;
import java.util.Scanner;

public class Method {    
    
    public static void Method(Comparable[] array, String metodName){            // Method() method which needs an array and the name of the sorting algorithm as input.                              
        
        metodName = metodName.toLowerCase();
        metodName = metodName.substring(0, 1).toUpperCase() + metodName.substring(1);
        switch (metodName) {                                                    // This method shortly does this:
            case "Selection":                                                   // Sorts the given array with the sorting algorithm the user wants.
                Selection.sort(array);                                          
                break;
                
            case "Insertion":                                                   // For example, if the given metodName is insertion, calls Insertion.sort.
                Insertion.sort(array);                                          // If it is merge, then calls Merge.sort etc.
                break;
                
            case "Merge":
                Merge.sort(array);
                break;
                
            case "Quick":
                Quick.sort(array);
                break;
            
            default:
                System.out.println("Enter a valid sorting algorithm");
                System.exit(0);
        }
        
        pairwiseDifference(array);                                              // Then, calls pairwiseDifference method with the array that has been just sorted.
         
    }
       
    public static void pairwiseDifference(Comparable[] array){                  // Method to find and print the smallest pairwise absolute difference along with the corresponding pair of numbers.
        int len = array.length;                                                 // It needs a sorted array input. 
        int firstElement = Integer.MAX_VALUE, secondElement = Integer.MAX_VALUE;// To find corresponding pair of numbers [firstElement, secondElement] and print them.
        int result = Integer.MAX_VALUE;                                         // Also this method starts from the 0th element, and iterates over the array until the end of array for only once.
        int temp = result;                                                      // Method has only one for-loop which goes over the n elements of the array for once.
                                                                                // Therefore, method has a running complexity of "O(n)".
        for (int i = 0; i < len-1; i++) {
            result = (Math.min(Math.abs((Integer)array[i+1] - (Integer)(array[i])), result));   // Here, we calculate the absolute difference for all two neighbouring elements in the array.
            if (temp != result) {                                               // If it is lesser than the result we have previously calculated, it becomes our new result value.
                if ((result < temp)) {                                          // Else our result value does not change.   
                    firstElement = (Integer)array[i];                           // Also, we keep an temp value in order to check if we have changed our result value or not.
                    secondElement = (Integer)array[i+1];                        // If it is changed and if it is lesser we also change our firstElement and secondElement with current elements.
                }                                                               // Since it is a sorted array, the lesser element pair will also be at the beginnig of the array.
                temp = result;
            }
        }

        System.out.println(result + " [" + firstElement + " " + secondElement + "]");   // We print out our result.
    }
        
    public static void main(String[] args) {                                    // Main mothod.
        Scanner scan = new Scanner(System.in);                                  
                                                                                // In the main method we only do:
        System.out.println("Enter the sort you want to use:");                  // 1- Get the wanted sorting algorithm as a String input (metodName) from the user.
        String metodName = scan.next();                                         // 2- Create the array.
                                                                                // 2- Call Method(array, metodName).
        Comparable[] array = {1, 4, 7, 23, 100, 102, 105, 107, 109, 113};                                                   
        Method(array, metodName);

        // TESTS //
    /* 
        Comparable[] arr1 = {101, 4684, 7453, 23453, 145300, 45345, 4945313, 453, 2963, 72675186};
        Comparable[] arr2 = {8, -94, 77, 2743, -15100, 0, -5, -107, 109, 13};
        Comparable[] arr3 = {-1, -1984, -47817, -16823, -1040, -1243112, -41861105, -156107, -1219, -6911};
        Method(arr1, "Insertion");
        Method(arr2, "Selection");
        Method(arr3, "Quick");
    */   
    
    }    
}
