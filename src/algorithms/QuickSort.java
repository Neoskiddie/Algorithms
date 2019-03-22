package algorithms;

/**
 *
 * @author Grzegorz Bronka
 */
public class QuickSort {
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
