import java.util.Objects;
public class HOA6 {
    public class Merge {                                                        // MERGE
    private static Comparable[] aux;
    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];                                         
        sort(a, 0, a.length - 1);
    }
    private static void sort(Comparable[] a, int lo, int hi) {                  
        if (hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        sort(a, lo, mid);                                                       
        sort(a, mid+1, hi);                                                     
        merge(a, lo, mid, hi);
 } 
    public static void merge(Comparable[] a, int lo, int mid, int hi) {         
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++)                                          
            aux[k] = a[k];
        for (int k = lo; k <= hi; k++)                                          
            if (i > mid)                            a[k] = aux[j++];
            else if (j > hi )                       a[k] = aux[i++];
            else if (high(aux[j], aux[i]))          a[k] = aux[j++];
            else                                    a[k] = aux[i++];	}
    private static boolean high(Comparable v, Comparable w) {                   
        return v.compareTo(w) > 0;                                                 }}
    public class Quick {                                                        //QUICK
    private static void exch(Comparable[] a, int i, int j) {
            Comparable temp = a[i]; a[i] = a[j]; a[j] = temp;   }
    public static void sortDesc(Comparable[] a) {                               
        sortDesc(a, 0, a.length - 1);}
    private static void sortDesc(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partitionDesc(a, lo, hi);
        sortDesc(a, lo, j-1);                                                    
        sortDesc(a, j+1, hi);
        for (Comparable c : a) {
            System.out.print(c + " ");
        } System.out.println("");  }
    private static int partitionDesc(Comparable[] a, int lo, int hi) {          
        int i = lo, j = hi+1;                                                    
        Comparable v = a[lo];                                                    
        while (true) {                                                           
            while (high(a[++i], v))         if (i == hi) break;
            while (high(v, a[--j]))         if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);}
        exch(a, lo, j);                                                            
        return j;}
    private static boolean high(Comparable v, Comparable w) {                   
        return v.compareTo(w) > 0;                                        }}
    public static void main(String[] args) {
        Comparable[] test = {4,10,9,3,14,5,11,1,8,13,6,7,2,12};                                                                                     
        Merge.sort(test);                                                      
        System.out.print("Merge:");                                             
        for (Comparable c: test) {                                              
            System.out.print(c + " ");                                          
        } System.out.println("\n");
        //----------------------------------------------------------------------
        Comparable[] test2 = {4,10,9,3,14,5,11,1,8,13,6,7,2,12};
        Quick.sortDesc(test2);  
        System.out.print("\n\nQuick:"); 
        for (Comparable c: test2) {                                              
            System.out.print(c + " ");                                          
        } System.out.println("\n");
}}
