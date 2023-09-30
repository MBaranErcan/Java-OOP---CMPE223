import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        String filename = "";
        System.out.print("Input filename:");
        filename = scan.nextLine();
        String text = null;
        
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader textReader = new BufferedReader(fr);
            
            DoubleLinkedStackOfIntegers stack = new DoubleLinkedStackOfIntegers();
            
            while((text = textReader.readLine()) != null) {
                String[] arrOfStr = text.split(" ");
                for (String a: arrOfStr) {
                    stack.push(Integer.parseInt(a));
                }
                
                int temp;
                while (!stack.isEmpty()) {
                    
                    for (Integer i: stack){
                        System.out.println(i);
                    }
                    
                
                }   
                
    
            }  
            textReader.close();
            
        } catch (FileNotFoundException ex) {
            System.out.println("File is not found!!!");
        } catch (IOException ex) {
            System.out.println("Error reading file!!!");
        }
        
        
        

        }
 /*   public static int[] getStockSpan(int[] prices) {

        int[] arr = new int[prices.length];
        DoubleLinkedStackOfIntegers stack = new DoubleLinkedStackOfIntegers();

        for ( int i = 0; i < prices.length; i++ ) {

            if ( stack.getSize() == 0 ) {

                arr[0] = 1;

            } else {

                if ( stack.peek() > prices[i] ) {

                    arr[i] = 1;

                } else {

                    int count = 1,t=0;
                    Iterator iter =stack.iterator();
                    int ia[]=new int[prices.length];
                    while ( iter.hasNext()  ) {
                        Integer k= (Integer)iter.next();

                        ia[t++]=k.intValue();
                    }
                    for(int j=t-1;j>=0;j--)
                    {

                        if(ia[j] <=  prices[i])
                            count++;
                        else
                            break;   
                    }
                    arr[i] = count;
                }
            }
            stack.push(prices[i]);
        }
        return arr;
    }
    
    */
    
  /*  
    public void consecutiveDayCalculator(int[] prices) {
        int size = prices.length;
        int res = Integer.MIN_VALUE;
        
        for (int i = 0; i < size ; i++) {
            if ()
        }
        
    }*/
}
