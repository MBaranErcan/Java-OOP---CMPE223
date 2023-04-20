public class AsalSayı {
    
    public static boolean AsalMı (int sayi) {
          for(int i=2; i<sayi; i++){
              if((sayi%i) == 0){
                  return false;
              }
             
          }
                return true;
        }
    
    
    public static void main(String[] args) {
        
        for (int i = 2; i < 1000; i++){
            
            if (AsalMı(i)){
                System.out.println(i);
                
            }
        }
        
        
    }
    
    
}
