import java.util.Arrays;

public class sorts {
    public compare comparar = new compare();

    /**
     * Metodo para el Gnome sort
     * @param result, una lista de tipo compare
     * @param n, el tamaño de la lista
     * @return result, la lista ordenada
     */
    public compare[] gnome(compare[] result,int n) {
        int i = 1;
        while (i < n) {
            if (i == 0)
                i++;
            if (result[i].compareTo(result[i-1]) >= 0)
                i++;
            else {
                compare temp = new compare();
                temp = result[i];
                result[i] = result[i - 1];
                result[i - 1] = temp;
                i--;
            }
        }return result;
    }


    /**
     * Metodo para el Bubble sort
     * @param result, una lista de tipo compare
     * @return result, la lista ordenada
     */
    public compare[] bubble(compare[] result) {
        int n = result.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (result[j].compareTo(result[j+1]) > 0) {
                    compare temp = result[j];
                    result[j] = result[j + 1];
                    result[j + 1] = temp;
                }
            }
        }
        return result;
    }


    /**
     *Unifica y ordena dos partes del array
     * @param result, una lista de tipo compare
     * @param l, el inicio de la lista
     * @param m, el punto medio de la lista
     * @param r, el indice final de la lista
     * @return
     */
    private compare[] merge(compare[] result, int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        compare L[] = new compare[n1];
        compare R[] = new compare[n2];

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
            if (L[i].compareTo(R[j]) <= 0) {
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

    /**
     * Funcion principal que ordena el array haciendo uso de merge
     * @param result, una lista de compare
     * @param l, el indice de inicio de la lista
     * @param r, el indice final de la lista
     * @return la lista ordenada
     */
    public compare[] mergeSort(compare[] result, int l, int r) {
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


    /**
     * Funcion que toma el ultimo elemento como pivote, lo coloca
     * en la posicion correcta, y coloca todos los mas pequeños que
     * el pivote antes de el pivote, y todos los mas grandes depues
     * del pivote
     * @param result, una lista de tipo compare
     * @param low, el indice de inicio de la lista
     * @param high, el indice final de la lista
     * @return el indice de un elemento mas grande
     */
    private int partition(compare[] result, int low, int high) {
        compare pivot = result[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (result[j].compareTo(pivot) <= 0)
            {
                i++;

                // swap arr[i] and arr[j]
                compare temp = result[i];
                result[i] = result[j];
                result [j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        compare temp = result[i+1];
        result[i+1] = result[high];
        result[high] = temp;

        return i+1;
    }
    /**
     * La funcion principal que implementa partition
     * @param result, una lista de tipo compare
     * @param low, el indice de inicio de la lista
     * @param high, el indice final de la lista
     * @return la lista ordenada
     */
    public compare[] quickSort(compare[] result, int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(result, low, high);
            // Recursively sort elements before
            // partition and after partition
            quickSort(result, low, pi-1);
            quickSort(result, pi+1, high);
        }return result;
    }


    /**
     * Funcion que obtiene el valor mas alto del array
     * @param result, lista de tipo compare
     * @param n, el largo de la lista
     * @return mx, el valor mas alto de la lista
     */
    private int getMax(compare[] result, int n)
    {
        int mx = result[0].getX();
        for (int i = 1; i < n; i++)
            if (result[i].getX() > mx)
                mx = result[i].getX();
        return mx;
    }
    /**
     * Funcion para hacer el conteo dependiendo
     * del exponencial
     * @param result, una lista de tipo compare
     * @param n, largo de la lista
     * @param exp, exponente
     */
    private void countSort(compare[] result, int n, int exp)
    {
        compare output[] = new compare[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[ (result[i].getX()/exp)%10 ]++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (i = n - 1; i >= 0; i--)
        {
            output[count[ (result[i].getX()/exp)%10 ] - 1] = result[i];
            count[ (result[i].getX()/exp)%10 ]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (i = 0; i < n; i++)
            result[i] = output[i];
    }
    /**
     * La funcion principal que ordena el array, haciendo
     * uso de get max, countSort
     * @param result, una lista de tipo compare
     * @param n, largo de la lista
     * @return la lista ordenada
     */
    public compare[] radixsort(compare[] result, int n)
    {
        // Find the maximum number to know number of digits
        int m = getMax(result, n);

        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        for (int exp = 1; m/exp > 0; exp *= 10)
            countSort(result, n, exp);
        return result;
    }
}