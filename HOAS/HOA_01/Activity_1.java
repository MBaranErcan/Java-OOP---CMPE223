package HOA_01;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Activity_1 {
    //---------------------------------------------------------------------------------------------
    //1-Write a static Java method that returns the largest element in a given integer array
    public static int returnLargest(int[] givenArray) {
        int largest = Integer.MIN_VALUE;

        if (givenArray.length >= 2) {
            for (int i=0; i<givenArray.length; i++) {
                int num = givenArray[i];

                largest = Integer.max(num, largest);
            }
            return largest;
        } System.out.println("Array too short!");
        return -1;
    }
    //---------------------------------------------------------------------------------------------
    //2-Write a static Java method that returns the second largest element in a given integer array
    public static int returnscndLargest(int[] givenArray) {
        int scndlargest = Integer.MIN_VALUE;
        int s = 0; //to check repetitive numbers
        
        if (givenArray.length >= 2) {
            Arrays.sort(givenArray);
            for (int i=givenArray.length-2; i>=0; i--){
                if (givenArray[i] == givenArray[givenArray.length-1] || s == givenArray.length-1) {
                    s++;
                    continue;
                }else {
                    scndlargest = givenArray[i];
                    return scndlargest;
                }
            }  
        } else
            System.out.println("Array too short!");
            return -1;
    }
    //---------------------------------------------------------------------------------------------
    //3-Write a static Java method that multiplies two given matrices and returns the result as a 2D array.
    public static double[][] multiply2Matrices (double[][] givenArray1, double[][] givenArray2) {

        int rows1 = givenArray1.length;
        int columns1 = givenArray1[0].length;
        int rows2 = givenArray2.length;
        int columns2 = givenArray2[0].length;
        
        double[][] ans = null;
        
         if (columns1 == rows2) {
             
            ans = new double[rows1][columns2];
            for (int i = 0; i < rows1; i++) {
                for (int j = 0; j < columns2; j++) {
                ans[i][j] = 0.00000;
                }
            }
            for (int i = 0; i < rows1; i++) { // 1Row
                for (int j = 0; j < columns2; j++) { // 2Column
                    for (int k = 0; k < columns1; k++) { // 1Column
                        ans[i][j] += givenArray1[i][k] * givenArray2[k][j];
                    }
                }
            }
        }else {
             System.out.println("Error");
         }      
        return ans;
    }
    //---------------------------------------------------------------------------------------------
    //4-Write a static Java method to reverse the elements of a	given integer array
    public static int[] reverser1(int[] givenArray) {
        int len = givenArray.length;
        int[] temp = new int[len];
        
        for (int i=0; i<len ;i++){
            temp[len-i-1] = givenArray[i];
        }
        return temp;
    }
    
    //---------------------------------------------------------------------------------------------
    //5-Write a static Java method to reverse the elements of a	given array, without temp array
    public static int[] reverser2(int[] givenArray) {
        int len = givenArray.length;
        int temp;
        
        for (int i=0; i<len/2 ;i++){
            temp = givenArray[i];
            givenArray[i] = givenArray[len-i-1];
            givenArray[len-i-1] = temp;
        }
        return givenArray;      
    }
    
    //---------------------------------------------------------------------------------------------
    //6-Write a	static method to randomly shuffle the elements in an array of double values.
    public static void shuffle(Double[] givenArray) {
        List<Double> list;
        list = Arrays.asList(givenArray);
        
        Collections.shuffle(list);
        list.toArray();
        System.out.println(Arrays.toString(givenArray));
    }
    
    //---------------------------------------------------------------------------------------------
    //7. Write a static	method that checks whether the given array of double values is sorted in ascending order.
    public static boolean orderCheckAscending(double[] givenArray) {
        int len = givenArray.length; 
        if (!(len<=1)) {
            boolean check;
            double[] testArr = new double[len];
            
            for (int i=0; i<len; i++) {
                testArr[i] = givenArray[i];
            }
            Arrays.sort(testArr);
            
            for (int i=0; i<len; i++) {
                if (testArr[i] != givenArray[i])
                    return false;
            }
         
            return true;
            
        }else {
            System.out.println("Array not valid");
            return false;
        }

    }
    

    
    public static void main(String[] args) {
    //    int[] test1 = {10,20,0,-55,189};
    //    Double[] test2 = {1.0,2.5,1.44,5.9};
        double[] test3 = {1.1,0.5,-1.44,5.0};
        double[] test4 = {1.1,1.5,2.44,5.0};
    //    System.out.println(reverser2(test1));
    //    shuffle(test2);
        System.out.println(orderCheckAscending(test3));
        System.out.println(orderCheckAscending(test4));
    }   
}
