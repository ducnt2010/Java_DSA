package Day6;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
//        int[] a1 = {1, 3, 5, 8, 9};
//        int[] a2 = {2, 4, 6};
//        int[] nums = {1, 3, 5, 2, 4, 6, 9, 8};
//        System.out.println(Arrays.toString(sortArraysss(nums, 0, nums.length - 1)));
//        sortArraysss(nums, 0, nums.length - 1);

        String[] a = {"a", "1"};
        String[] b = {"b", "12"};
        String[] c = {"d", "10"};

        String[][] arr = {a, b, c};
        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[1].compareTo(o2[1]);
            }
        });
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][0] + " "); // output: a, d, b
        }
    }

    private static void merge(int[] a, int left, int mid, int right) {
        // sort and merge a[] from left -> right
        // sub array left -> mid
        // sub array mid+1 -> right
    }

    private static int[] sortArraysss(int[] a, int left, int right) {
        System.out.println("chia left= " + left + " ,right= " + right);
        if (left == right) {
            return new int[]{a[left]};
        }
        int mid = left + (right - left) / 2;
        int[] aLeft = sortArraysss(a, left, mid);
        int[] aRight = sortArraysss(a, mid + 1, right);
        System.out.println("merge: left= " + left + " ,right= " + right);
        int[] res = merge2Array(aLeft, aRight);
        return res;
    }

    private static int[] merge2Array(int[] a1, int[] a2) {
        int[] res = new int[a1.length + a2.length];
        int idx = 0;
        int i = 0, j = 0;
        while (i < a1.length && j < a2.length) {
            if (a1[i] < a2[j]) {
                res[idx] = a1[i];
                i++;
            } else {
                res[idx] = a2[j];
                j++;
            }
            idx++;
        }
        while (i < a1.length) {
            res[idx] = a1[i];
            idx++;
            i++;
        }
        while (j < a2.length) {
            res[idx] = a2[j];
            idx++;
            j++;
        }
        return res;
    }
}
