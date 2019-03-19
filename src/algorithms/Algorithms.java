/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.Arrays;

/**
 *
 * @author user
 */
public class Algorithms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int[] myArr = {1, 4, 3, 2, 9, 77, 66, 55, 999, 33, 3333, 0,22};
        mergeSort(myArr, 0, myArr.length  - 1);
        System.out.println(Arrays.toString(myArr));
        quickSort(myArr, 1, myArr.length  - 2);
        System.out.println(Arrays.toString(myArr));
    }

    public static void mergeInPlace(int[] a, int left, int mid, int right) {
        // step 1
        int n1 = mid - left + 1;
        int n2 = right - mid;

        //step 2
        int[] a1 = new int[n1]; //new array that will be copy of "a" array from left to mid
        for (int i = left; i <= mid; i++) {
            int newPosition = i - left;
            a1[newPosition] = a[i];//copying by setting element of a1 array to value of element of a array
        }
        //just for debuging 
        System.out.println("A1 = " + Arrays.toString(a1));
        
        //step 3
        int[] a2 = new int[n2];
        for (int i = mid + 1; i <= right; i++) {
            int newPosition = i - mid - 1;
            a2[newPosition] = a[i];//copying by setting element of a1 array to value of element of a array
        }
        //just for debuging 
        System.out.println("A2 = " + Arrays.toString(a2) );
        
        //step 4
        int i = 0, j = 0;
        int k = left;
        
        //step 5
        while (i < n1 && j < n2) {
            if (a1[i] <= a2[j]) {
                // I'm aware that j, k and i could be incremented like a[k++] (like it was shown in lectures, because ++ operation is done after asignment, 
                // but it seems more readable outside - for me personaly it is clearer which operation is done when
                a[k] = a1[i];
                i++;
            } else {
                a[k] = a2[j];
                j++;
            }
            k++;
        }
        //step 6
        while (i < n1 ) {
            a[k] = a1[i];
            i++;
            k++;
        } 
        //step 7
        while(j < n2) {
            a[k] = a2[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int m = (left + right) / 2;
        mergeSort(a, left, m);
        mergeSort(a, m + 1, right);
        mergeInPlace(a, left, m, right);
    }
    
    public static int partition(int[] a, int left, int right) {
        int pivot = a[left + (right - left) / 2]; 
        
        //why in the task is it -1 and +1 - it makes it imposiible to pass array from 0 to end of array instead I passed array from 1 and length - 2
        int x = left - 1;
        int y = right + 1;
        
        
        while(true) {
            while(a[x] < pivot) {
                x++;
            }
            while(a[y] > pivot) {
                y--;
            }
            if (x < y) {
                    int temp = a[y];
                    a[y] = a[x];
                    a[x] = temp;
                } else {
                    return y;
                }
        }
    }
    
    public static void quickSort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int q = partition(a, left, right);
        quickSort(a, left, q);
        quickSort(a, q + 1, right);
    }
    
    
    
    

}
