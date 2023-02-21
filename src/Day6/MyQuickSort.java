package Day6;

import java.util.Arrays;

public class MyQuickSort {
    public static void main(String[] args) {
        // pivot=9
        // chia lam 2 phan
        // left < 9
        // right > 9
        int[] a = {9, 7, 5, 8, 4, 1, 2};
        System.out.println("init: " + Arrays.toString(a));

        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int sortedItem = partition(arr, low, high);// tim duoc 1 phan tu sorted
            quickSort(arr, low, sortedItem - 1);
            quickSort(arr, sortedItem + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
//        System.out.println("partition from " + low + " to " + high);
        int pivot = arr[low];
        int left = low + 1;
        int right = high;
        while (true) {
            // tim phần tử phía bên trái mà > pivot
            while (left <= right && arr[left] < pivot) {
                left++; //
            }// tim duoc arr[left] > pivot
            while (left <= right && arr[right] > pivot) {
                right--;
            }
            if (left >= right) {
                break;
            }
            swap(arr, left, right);

            left++;
            right--;
        }
//        System.out.println("pivot= " + pivot + " index= " + low + " - right= " + right);
        swap(arr, low, right);
//        System.out.println("result: "+Arrays.toString(arr));
        return right;
    }

    private static void swap(int[] arr, int i, int j) {
//        System.out.println("swapped index "+i+" and "+j + " value: "+arr[i] + " to "+arr[j]);
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
//        System.out.println("after swapped: "+Arrays.toString(arr));

    }
}
