package Day8;

import java.util.Arrays;
import java.util.Random;

public class Sort {
    public static void main(String[] args) {
        int[] input = new int[100000];
        Random random = new Random();
        for (int i = 0; i < input.length; i++) {
            input[i] = random.nextInt(input.length);
        }
        int[] arr1 = Arrays.copyOf(input, input.length);
        int[] arr2 = Arrays.copyOf(input, input.length);
        int[] arr3 = Arrays.copyOf(input, input.length);

        long t1 = System.currentTimeMillis();
        mergeSort(arr1, 0, arr1.length - 1);
        long t2 = System.currentTimeMillis();
        System.out.println("Merge sort Time = " + (t2 - t1));
        bubbleSort(arr2);
        long t3 = System.currentTimeMillis();
        System.out.println("Bubble sort Time = " + (t3 - t2));
        quickSort(arr3, 0, arr3.length - 1);
        long t4 = System.currentTimeMillis();
        System.out.println("Quick sort Time = " + (t4 - t3));

        //System.out.println("result: " + Arrays.equals(arr1, arr2));
    }

    private static void bubbleSort(int[] input) {
        int n = input.length; // 1 op
        // quy tac nhan: n*n
        for (int i = 0; i < n - 1; i++) { // 2n+1
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) { // ~2n-1
                if (input[j] > input[j + 1]) {
                    swap(input, j, j + 1);
                    swapped = true;
                    // 3 ops -> 1 ops
                }
                // n-1
                // n-2
                // n-3///
                // 0
                // (n-1) + (n-2) +...+0
                //cong tat ca cac so tu 1 den n
                // -> (n-1)n/2 = n^2
            }
            if (!swapped) {
                break;
            }
        }
    }

    private static void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    //////

    private static void merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    private static void mergeSort(int arr[], int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;

            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    ///
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    static void quickSort(int[] input, int low, int high) {
        if (low < high) {
            int pi = partition(input, low, high);
            quickSort(input, low, pi - 1);
            quickSort(input, pi + 1, high);
        }
    }
}
