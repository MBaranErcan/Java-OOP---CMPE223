//-----------------------------------------------------
// Title: Insertion sort class
// Author: Mustafa Baran Ercan
// ID: 28810555206
// Section: 6
// Assignment: 2
// Description: This class defines the Insertion sort algorithm.
//-----------------------------------------------------
public class Insertion {
    
    public static void sort(Comparable[] a) {                                   // Sort a[] into increasing order.
    int N = a.length;
    for (int i = 1; i < N; i++) {                                               // Insert a[i] among a[i-1], a[i-2], a[i-3]... ..
        for (int j = i; j > 0 && less(a[j], a[j-1]); j--)
            exch(a, j, j-1);
        }
    }

    private static boolean less(Comparable v, Comparable w) {                   // less method on page 245
        return v.compareTo(w) < 0; }
    
    private static void exch(Comparable[] a, int i, int j) {                    //  exch method on page 245
        Comparable t = a[i]; a[i] = a[j]; a[j] = t; }
}