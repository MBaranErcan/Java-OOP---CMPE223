class Solution {
    public int romanToInt(String s) {
   
    System.out.println("s = \"" + s + "\"");
       
    int length = s.length();  
    int value = 0;
    
    
    if (s.equals("IV")){
        value = 4;
    } else if (s.equals("IX")) {
        value = 9;
    } else if (s.equals("XL")) {
        value = 49;
    } else if (s.equals("XC")) {
        value = 99;
    } else if (s.equals("CD")) {
        value = 499;
    } else if (s.equals("CM")) {
        value = 999;
    }else {      
        for (int i=0; i< length ; i++ ) {
           if(s.substring(i, i+1).equals("I")) {
            value++; 
         } else if(s.substring(i, i+1).equals("V")) {
            value = value + 5; 
         } else if(s.substring(i, i+1).equals("X")) {
            value = value + 10; 
         } else if(s.substring(i, i+1).equals("L")) {
            value = value + 50; 
         } else if(s.substring(i, i+1).equals("C")) {
            value = value + 100; 
         } else if(s.substring(i, i+1).equals("D")) {
            value = value + 500; 
         } else if(s.substring(i, i+1).equals("M")) {
            value = value + 1000; 
         }
 
       }
        
    } return value; 
    
  }    
    
    
}
