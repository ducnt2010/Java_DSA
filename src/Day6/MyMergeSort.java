package Day6;

import java.util.Arrays;

public class MyMergeSort {
    public static void main(String[] args) {
//        int[] a1 = {3, 5, 9, 10, 20, 21};
//        int[] a2 = {2, 4, 6, 8};
//
//        int[] res = merge2Arrays(a1, a2);
//        System.out.println(
//                Arrays.toString(res)
//        );
        int[] arr = {1, 5, 3, 2, 8, 7, 6, 4};
        System.out.println("array: " + Arrays.toString(arr));

        int[] res=mergeSort(arr, 0, arr.length-1);
        System.out.println("res= "+Arrays.toString(res));
    }

    private static int[] mergeSort(int[] arr, int left, int right) {
        // MẢNG có duy nhất 1 phần tử -> chắc chắn sorted
        // lấy ra mảng có 1 phần tử
//        System.out.println("chia doi mang tu " + left + " den " + right);
        if (left == right) { // base condition
//            System.out.println("Mang co 1 phan tu index= "+left + " , value= "+arr[left]);
            return new int[]{arr[left]};
        }
        int mid = left + (right - left) / 2;
        int[] a1 = mergeSort(arr, left, mid);
        int[] a2 = mergeSort(arr, mid + 1, right);

        int[] res = merge2Arrays(a1, a2);
//        System.out.println("Done merge tu " + left + " den " + right);
//        System.out.println(Arrays.toString(res));
        return res;
    }

    private static int[] merge2Arrays(int[] a1, int[] a2) { // merge 2 mảng đã sắp xếp
        // a1, a2 --- Sorted
        int[] res = new int[a1.length + a2.length];

        int idx = 0; // current index for updating
        int i = 0; // for a1
        int j = 0; // for a2
//        int[] a1 = {3, 5, 9, 10, 20, 21};
//        int[] a2 = {2, 4, 6, 8};

        while (i < a1.length && j < a2.length) { // true && true
            // break khi i hoặc j chạy hết mảng
            if (a1[i] < a2[j]) {
                // phần tử đang xét tại a1 < phần tử đang xét tại a2
                res[idx] = a1[i];// thêm a[i] vào res -> a[i] xem như đã được remove
                i++;  // tăng i để xét phần tử kế tiếp
            } else {
                res[idx] = a2[j];
                j++;
            }
            // luôn ưu tiên lấy phần tử nhỏ để nhét vào res --> KEYWORD
            idx++;
        }

//        System.out.println("i= " + i + " --- j= " + j);
        // i=2 -> a1[2] = 9
        // j=4 -> a2[4] ko tồn tại vì tận cùng là a2[3] thôi

        while (i < a1.length) { // a1 còn, chắc chắn a2 đã hết
            // điền tất cả phần tử còn lại của a1 vào res
            res[idx] = a1[i];
            idx++;
            i++;
        }

        while (j < a2.length) {
            res[idx] = a2[j];
            idx++;
            j++;
        }

        //return res[] duoc sap xep, merged tu a1 va a2
        // 1,2,3,4,5,6,7,8
        return res;
    }
}
