package algorithms;

/**
 *
 * @author Grzegorz Bronka
 */
public class MergeSort {
    public static void mergeInPlace(int[] a, int left, int mid, int right) {
        
        //step 1
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        //step 2
        int[] a1 = new int[n1];
        for (int i = left; i <= mid; i++) {
            int newPosition = i - left;
            a1[newPosition] = a[i];
        }
        //step 3
        int[] a2 = new int[n2];
        for (int i = mid + 1; i <= right; i++) {
            int newPosition = i - mid - 1;
            a2[newPosition] = a[i];
        }
        //step 4
        int i = 0, j = 0;
        int k = left;
        //step 5
        while (i < n1 && j < n2) {
            //step 5.1
            if (a1[i] <= a2[j]) {
                // I'm aware that j, k and i could be incremented like a[k++] (like it was shown in lectures, because ++ operation is done after asignment, 
                // but it seems more readable outside - for me personaly it is clearer which operation is done when
                a[k] = a1[i];
                i++;
            //step 5.2
            } else {
                a[k] = a2[j];
                j++;
            }
            k++;// in both cases it is incremented, so no need to write it twice inside if else
        }
        //step 6
        while (i < n1 ) {
            //step 6.1
            a[k] = a1[i];
            i++;
            k++;
        } 
        //step 7
        while(j < n2) {
            //step 7.1
            a[k] = a2[j];
            j++;
            k++;
        }
        //step 8
        return; 
    }

    public static void mergeSort(int[] a, int left, int right) {
        //step 1
        if (left >= right) {
            return;
        }
        //step 2
        int m = (left + right) / 2;
        //step 3
        mergeSort(a, left, m);
        //step 4
        mergeSort(a, m + 1, right);
        //step 5
        mergeInPlace(a, left, m, right);
    }
}
