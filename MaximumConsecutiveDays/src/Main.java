//-----------------------------------------------------
// Title: Main class
// Author: Mustafa Baran Ercan
// ID: 28810555206
// Section: 6
// Assignment: 1
// Description: This class opens and reads the file, and make the essential operations to calculate the results with using a Stack from MyStack class.
//-----------------------------------------------------
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {                                    // Main class.
        Scanner scan = new Scanner(System.in);                                  // Scanner object.
        
        
        String fileName = "";                                                   // Asks for the file name.
        System.out.print("Input filename:");                                    // Stores the input as String.
        fileName = scan.nextLine();                                             //
        
        try {                                                                   
            FileReader fr = new FileReader(fileName);                           // Uses fileName in FileReader to read the file
            BufferedReader bufferedReader = new BufferedReader(fr);             
            
            String line;                                                        // One String line 
            String[] stringPrices = null;                                       // Our String array object in order to keep prices.
                      
            while ((line = bufferedReader.readLine()) != null) {                // In order to check if there are still lines left to read in text file.
                stringPrices =line.split(" ");                                  // We use split(" ") method to seperate each integer price value from one big merged string line.
            }             
            int[] res = new int[stringPrices.length];                           // Our array of integers named result.
                                                                                // After calling the maxConsecutiveDaysCalculator method, we keep the each wanted result value in this result array. 
            res = maxConsecutiveDaysCalculator(stringPrices);                   // Each value represents the maximum number of consecutive days (starting today and going backwards) that the bitcoinvalue was higher than or equal to today's value.
                                                                                // (maxConsecutiveDaysCalculator is written below)
            System.out.print("[");
                for (int i = 0 ; i < res.length; i++) {                                                 
                    if(i == res.length-1)
                        System.out.print(res[i]);
                    else System.out.print(res[i] + ",");}                                          // We simply print out the each element of the result array.
            System.out.print("]");
   
        } catch (FileNotFoundException FNFE) {
            System.out.println("File not found!!!");                            // Catches FileNotFoundException.
        } catch (IOException IOE) {
            System.out.println("File did not read correctly!!!");               // Catches IOException.
        } catch (NullPointerException NPE) {
            System.out.println("List is empty");
        }
    }
        public static int[] maxConsecutiveDaysCalculator(String[] prices) {     // Method where we use stack and iterator.
                                                                                // Method input must be in the form of String array, and the output is an integer array.
        int[] res = new int[prices.length];                                     // What we want to do in this method is simple:
        MyStack<Integer> stack = new MyStack<>();                               // Run loop through the array, adding an array value to the stack each time.
                                                                                // If the stack is empty, set the first array element as 1 
        for ( int i = 0; i < prices.length; i++ ) {                             // Else, if stack.peek() is greater then add 1.
                                                                                // If the stack.peek() returns a smaller value then continue looping through the stack as long as there are smaller or equal values.
            if ( stack.getSize() == 0 ) {                                       // 
                res[0] = 1;                                                     // 
            } else {                                                            //
                if ( stack.peek() > Integer.valueOf(prices[i]) ) {              // 
                                                                                // Here is explanation step by step:
                    res[i] = 1;                                                 // 
                                                                                // Start with taking a string array named prices as input (in our main method it equals stringPrices).
                } else {                                                        // We create an integer array, which is the array we want our method to return at the end.
                    int count = 1 , t = 0;                                      // It is also named result, since we use a same-named result array in our main method it is easier to follow.
                    Iterator it = stack.iterator();                             // Then, we instantiate a Stack object which we have written in MyStack class.
                    int arr[] = new int[prices.length];                         // We use peek to fetch the element present at the top of the Stack.
                    while ( it.hasNext() ) {                                    // If the size of the Stack is zero(empty stack), since there are no need to make comparison,
                        Integer k = (Integer)it.next();                         // we return one for the one and only result value.
                        arr[t++] = k;                                           // We iterate over stack.
                    }                                                           // Else part is done if the size of the Stack is bigger than one (like in most cases).
                    for( int j = t-1 ; j >= 0 ; j--) {                          // If the value of bitcoin is larger or equal, we increase the count value by one.
                                                                                // It stops if the bitcoin price is lesser than, or it is the en of the Stack.
                        if( arr[j] <= Integer.valueOf(prices[i]) )              // Returns the result value.
                            count++;                                            //
                        else
                            break;   
                    }
                    res[i] = count;
                }
            }
            stack.push(Integer.valueOf(prices[i]));
        }
        return res;
    }
}
