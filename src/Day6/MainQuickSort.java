package Day6;

import java.util.Arrays;

public class MainQuickSort {
    public static void main(String[] args) {
        int[] nums = {1,8,3,9,4,5,7};
        System.out.println("init: "+Arrays.toString(nums));

        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int sortedIndex = partition(arr, low, high);
            quickSort(arr, low, sortedIndex - 1);
            quickSort(arr, sortedIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int left = low + 1;
        int right = high;
        while (true) {
            while (left <= right && arr[left] < pivot) {
                left++;
            }
            while (right >= left && arr[right] > pivot) {
                right--;
            }
            if (left >= right) {
                break;
            }
            swap(arr, left, right);
            left++;
            right--;
        }
        swap(arr, right, low);
        return right;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
