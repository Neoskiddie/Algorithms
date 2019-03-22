package algorithms;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Grzegorz Bronka
 * I implemented this algorithms for array of int
 */
public class Algorithms {
    public static int nCompares = 0; // added in Q2
    public static int nAssigns = 0;
    
    private static Random generator = new Random(); 
    
    
    
    public static void main(String[] args) {
        MergeCheck();
        QuickCheck();
        
    }
     public static void MergeCheck() {
        int arraySize = 10;
        int rangeOfNumbers = 100;
        int numReps = 30;

        for (int i = 0; i < numReps; i++) {
            int[] a = randomArray(arraySize, rangeOfNumbers);
            int[] check = Arrays.copyOf(a, a.length);
            Arrays.sort(check);
            System.out.println("Unsorted:" + Arrays.toString(a));
            MergeSort.mergeSort(a, 0, arraySize - 1);
            System.out.println("Sorted by MergeSort:" + Arrays.toString(a));
            System.out.println("Sorted by build in java method:" + Arrays.toString(check));
            System.out.println("Arrays are same object: " + a.equals(check));
            System.out.println("Arrays are equal: " + Arrays.equals(a, check));
            System.out.println("-------------------------------------------------------------------");
        }
     }
     public static void QuickCheck() {
        int arraySize = 100;
        int rangeOfNumbers = 100;
        int numReps = 100;

        for (int i = 0; i < numReps; i++) {
            int[] a = randomArray(arraySize, rangeOfNumbers);
            int[] check = Arrays.copyOf(a, a.length);
            Arrays.sort(check);
            System.out.println("Unsorted:                      " + Arrays.toString(a));
            QuickSort.quickSort(a, 0, arraySize - 1);
            System.out.println("Sorted by QuickSort:           " + Arrays.toString(a));
            System.out.println("Sorted by build in java method:" + Arrays.toString(check));
            System.out.println("Arrays are same object: " + a.equals(check));
            System.out.println("Arrays are equal: " + Arrays.equals(a, check));
            System.out.println("-------------------------------------------------------------------");
        }
     }
    public static int[] randomArray(int arraySize, int rangeOfNumbers){
        int[] a = new int[arraySize];
        for (int i = 0; i < a.length; i++) {
            a[i] = generator.nextInt(rangeOfNumbers);
        }
        return a;
    }

 

}
