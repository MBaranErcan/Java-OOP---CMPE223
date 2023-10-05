//-----------------------------------------------------
// Title: SortingAlgorithmTester class
// Author: Mustafa Baran Ercan
// ID: 28810555206
// Section: 6
// Assignment: 2
// Description: This class is for creating different sized arrays and sorting arrays with given sorting algorithm.
//-----------------------------------------------------
import java.util.*;

public class SortingAlgorithmTester {
    public static void main(String[] args) {
         
        Scanner scan = new Scanner(System.in);                                  // Scanner object.
         
        int[] inputSize = {250, 1000, 4000, 16000, 64000};                      // Sizes of the inputs we want to use.
        String[] sortType = {"Selection", "Insertion", "Merge", "Quick"};       // Types of the sorts we want to use.
        String[] arrayType = {"Random", "Ascending", "Descending"};             // Types of the arrays we want to use.
        Random random = new Random();                                           // Random instance.
        
        System.out.println("Enter a seed to create random generated values :");
        long seed = scan.nextInt();
        System.out.println("Seed : " + seed);
        random.setSeed(seed);                                                   // Get the seed input for the Random object from the user.
        
        
        for (int i = 0; i < inputSize.length; i++) {                            // Repeat for each inputSize value (For example 250, 1000, 4000, 16000, 64000 (i=5 times))
            
            Comparable[] array = new Comparable[inputSize[i]];                  // Create arrays with sizes of current inputSize (250, 1000, ... etc.)
            System.out.println("Input size: "+ array.length);
            for (int a = 0; a < array.length; a++) {                            // Fill array[a] with random integer values i times. (a=250, 1000, 4000...)
                array[a] = random.nextInt();
            }
            
            for (int j = 0; j < sortType.length; j++) {                         // Repeat 4 times (for Selection, Insertion, Merge, Quick).
                
                System.out.println("\nSort option: " + sortType[j]);
                for (int k = 0; k < arrayType.length; k++) {                    // Repeat 3 times (for Random, Ascending, Descending).
                    
                    System.out.println(arrayType[k]);
                    
                    if (k==0)                                                   // k=0 is for Random, k=1 is for Ascending and k=2 is for Descending array type.
                        for (int r = 0; r < 3; r++) {                           // For each k value, we evaluate test cases 3 times (from r=0 upto r<3).
                                                                                // We create an "times" array of long to store runtimes of each computation, but since the wanted output
                            Long[] times = new Long[3];                         // does not include running times, they are under comment.
                            Long t1 = System.currentTimeMillis();
                            Method.Method(array, sortType[r].toLowerCase());
                            Long t2 = System.currentTimeMillis();
                            times[r] = t2-t1;
                            //System.out.println("Time:"+times[r]);
                        }
                    if (k==1)
                        for (int r = 0; r < 3; r++) {

                            Long[] times = new Long[3];
                            Arrays.sort(array);
                            Long t1 = System.currentTimeMillis();
                            Method.Method(array, sortType[r].toLowerCase());
                            Long t2 = System.currentTimeMillis();
                            times[r] = t2-t1;
                            //System.out.println("Time:"+times[r]);
                        }
                    if (k==2)
                        for (int r = 0; r < 3; r++) {

                            Long[] times = new Long[3];
                            Arrays.sort(array, Collections.reverseOrder());
                            Long t1 = System.currentTimeMillis();
                            Method.Method(array, sortType[r].toLowerCase());
                            Long t2 = System.currentTimeMillis();
                            times[r] = t2-t1;
                            //System.out.println("Time:"+times[r]);
                        }
                    
                }
                
            }
            
        }
            
    }
    
}
