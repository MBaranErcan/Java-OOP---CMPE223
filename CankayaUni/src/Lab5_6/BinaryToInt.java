package Lab5_6;

import java.util.Stack;

public class BinaryToInt {

    static int convertBinaryToInt(String binString) {
        int res = 0;
        int len = binString.length();
        
	Stack<Integer> s=new Stack<>();
	
        for (int i = 0; i < len; i++) {
            s.push(binString.charAt(i)-48);
        }
	for (int i = 0; i < len; i++) {        
           res += s.pop() * (Math.pow(2, i));
        }
	return res;
    }

    
    public static void main(String[] args) {
        
       String testString = "1001101";
       int testInt = convertBinaryToInt(testString);
        System.out.println(testInt);
    }
}
