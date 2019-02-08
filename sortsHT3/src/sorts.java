import java.util.Arrays;

public class sorts {
    public compare comparar = new compare();

    public int[] gnome(int[] result) {
        compare va1 = new compare();
        compare va2 = new compare();

        for (int i = 1; i <= result.length; ) {
            va1.setX(result[i]);
            va2.setX(result[i - 1]);

            if (va1.compareTo(va2) < 0)
                ++i;

            else {

                int tempValue = result[i];
                result[i] = result[i - 1];
                result[i - 1] = tempValue;
                --i;

                if (i == 0)
                    i = 1;

            }
        }
        return result;
    }

    public int[] bubble(int[] result) {
        int n = result.length;
        compare va1 = new compare();
        compare va2 = new compare();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                va1.setX(result[j]);
                va2.setX(result[j + 1]);

                if (va1.compareTo(va2) > 0) {
                    int temp = result[j];
                    result[j] = result[j + 1];
                    result[j + 1] = temp;
                }
            }
        }
        return result;
    }

    private int[] merge(int[] result, int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = result[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = result[m + 1 + j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            compare va1 = new compare();
            compare va2 = new compare();
            va1.setX(L[i]);
            va2.setX(R[j]);
            if (va1.compareTo(va2) <= 0) {
                result[k] = L[i];
                i++;
            } else {
                result[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            result[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            result[k] = R[j];
            j++;
            k++;
        }
        return result;
    }

    // Main function that sorts arr[l..r] using
    // merge()
    public int[] mergeSort(int result[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            mergeSort(result, l, m);
            mergeSort(result, m + 1, r);

            // Merge the sorted halves
            merge(result, l, m, r);
        }
        return result;
    }
    /* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */
    private int partition(int result[], int low, int high) {
        int pivot = result[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            compare va1 = new compare();
            compare va2 = new compare();
            va1.setX(result[j]);
            va2.setX(pivot);
            // If current element is smaller than or
            // equal to pivot
            if (va1.compareTo(va2) <= 0)
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = result[i];
                result[i] = result[j];
                result [j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = result[i+1];
        result[i+1] = result[high];
        result[high] = temp;

        return i+1;
    }


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    public int[] quickSort(int arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);
            // Recursively sort elements before
            // partition and after partition
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }return arr;
    }
    // A utility function to get maximum value in arr[]
    static int getMax(int arr[], int n)
    {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(int arr[], int n, int exp)
    {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[ (arr[i]/exp)%10 ]++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (i = n - 1; i >= 0; i--)
        {
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
            count[ (arr[i]/exp)%10 ]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    // The main function to that sorts arr[] of size n using
    // Radix Sort
    public int[] radixsort(int arr[], int n)
    {
        // Find the maximum number to know number of digits
        int m = getMax(arr, n);

        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        for (int exp = 1; m/exp > 0; exp *= 10)
            countSort(arr, n, exp);
        return arr;
    }
}