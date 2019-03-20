package algorithms;

import java.util.Arrays;

/**
 *
 * @author Grzegorz Bronka
 * I implemented this algorithms for array of int
 */
public class Algorithms {

    public static void main(String[] args) {

        int[] myArr = {1, 4, 3, 2, 9, 77, 66, 55, 999, 33, 3333, 0,22};
        mergeSort(myArr, 0, myArr.length  - 1);
        System.out.println(Arrays.toString(myArr));
//        quickSort(myArr, 0, myArr.length - 1);
//        System.out.println(Arrays.toString(myArr));
    }

    public static void mergeInPlace(int[] a, int left, int mid, int right) {
 
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] a1 = new int[n1];
        for (int i = left; i <= mid; i++) {
            int newPosition = i - left;
            a1[newPosition] = a[i];
        }
        
        int[] a2 = new int[n2];
        for (int i = mid + 1; i <= right; i++) {
            int newPosition = i - mid - 1;
            a2[newPosition] = a[i];
        }
        
        int i = 0, j = 0;
        int k = left;
        
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
            k++;// in both cases it is incremented, so no need to write it twice inside if else
        }

        while (i < n1 ) {
            a[k] = a1[i];
            i++;
            k++;
        } 

        while(j < n2) {
            a[k] = a2[j];
            j++;
            k++;
        }
        return; //it will terminate anyway, but 8th step is to terminate so here it is
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
        int pivot = a[(left + right) / 2]; 
        
        int x = left - 1;
        int y = right + 1;
        
        
        while(true) {
            do {
                x++;
            } while(a[x] < pivot);
            do {
                y--;
            } while(a[y] > pivot);
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
