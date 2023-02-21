package Day5;

public class Main {
    public static void main(String[] args) {
        System.out.println((int) Math.sqrt(8));
    }


    private static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) { // left == right -> mảng con chỉ chứa duy nhất 1 phần tử: a[left]=a[mid]=a[right]
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                // range: mid+1 -> right
                left = mid + 1;
            } else {
                // range: left -> mid-1
                right = mid - 1;
            }
        }
        /// left > right --> dieu kien dung
        return -1;
    }

    private static int binarySearchRecursion(int[] arr, int target, int left, int right) {
        // dieu kien dung
        if (left > right) return -1;

        int mid = (left + right) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] < target)
            // range: mid+1 -> right
            return binarySearchRecursion(arr, target, mid + 1, right);

        // range: left -> mid-1
        return binarySearchRecursion(arr, target, left, mid - 1);

        // bai toan con, cong thuc quy nap
        // xet nhung mang con ben trai/phai de tim target
    }

    public int mySqrt(int x) {
        int left = 0, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (x / mid == mid) {
                return mid;  // mid^2 = x
            }
            if (x / mid > mid) {
                left = mid + 1; // mid vẫn còn chưa đủ lớn -> cần check ở range lớn hơn
            } else {
                right = mid - 1; // mid đã lớn quá rồi -> cân check range nhỏ hơn
            }
        }
        return right;
    }
}
