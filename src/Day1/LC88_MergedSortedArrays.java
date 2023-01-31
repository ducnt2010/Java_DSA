package Day1;

public class LC88_MergedSortedArrays {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int lengthOfNums1 = m;
        int lengthOfNums2 = n;
        for (int i = 0; i < nums2.length; i++) { // lay ra phan tu trong mang nums2
            for (int j = 0; j < lengthOfNums1; j++) {
                if (nums2[i] < nums1[j]) {
                    insert(j, nums2[i], lengthOfNums1, nums1);
                    lengthOfNums1++;
                    lengthOfNums2--;
                    break;
                }
            }
        }
        if (lengthOfNums2 > 0) {
            int index = m + n - lengthOfNums2;
            while (index < m + n) {
                nums1[index] = nums2[n - lengthOfNums2];
                index++;
                lengthOfNums2--;
            }
        }
    }

    private static void insert(int index, int number, int lengthOfNums1, int[] arr) {
        for (int i = lengthOfNums1; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = number;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
    }
}
