package algorithms;

/**
 *
 * @author Grzegorz Bronka
 */
public class MergeSort {
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
}
