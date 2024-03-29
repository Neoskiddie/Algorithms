package algorithms;

/**
 *
 * @author Grzegorz Bronka
 */
public class QuickSort {
    public static int partition(int[] a, int left, int right) {
        //step 1
        int pivot = a[(left + right) / 2]; 
        //step 2
        int x = left - 1;
        int y = right + 1;
        
        //step 3
        while(true) {
            //step 3.1
            do {
                x++;
            } while(a[x] < pivot);
            //step 3.2
            do {
                y--;
            } while(a[y] > pivot);
            //step 3.3
            if (x < y) {
                    int temp = a[y];
                    a[y] = a[x];
                    a[x] = temp;
                //step 3.4
                } else {
                    return y;
                }
        }
    }
    
    public static void quickSort(int[] a, int left, int right) {
        //step 1
        if (left >= right) {
            return;
        }
        //step 2
        int q = partition(a, left, right);
        //step 3
        quickSort(a, left, q);
        //step 4
        quickSort(a, q + 1, right);
    }
}
