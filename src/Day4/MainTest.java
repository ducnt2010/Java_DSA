package Day4;

public class MainTest {
    static int count = 0;

    public static void main(String[] args) {
        int[] arr = new int[1000];
        arr[1] = arr[2] = 1;
        for (int i = 3; i <= 10; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        System.out.println(arr[10]);

        int[] a = {0, 1, 20, 13, 4, 5, 6, 7, 8};
        System.out.println(sum(3,a)); //--> 0+1+20+13=34
    }

    // sum tu index = 0 -> n bat ki
    private static int sum(int n, int[] arr) {
        // dieu kien dung
        if (n < 0) {
            // sum -> 0;
            return 0;
        }
        return arr[n] + sum(n - 1, arr);
    }

    // duyet mang 2 chieu bang de quy

    private static int fibo2(int n, int[] arr) {
        System.out.println("start n= " + n);
        count++;
        if (n <= 2) {
            System.out.println("end n= " + n);
            return 1;
        }
        if (arr[n] == 0) { // arr[n] da duoc tinh
            arr[n] = fibo2(n - 1, arr) + fibo2(n - 2, arr);
        }
        System.out.println("end n= " + n);
        return arr[n];
        // memory caching
        // cache
    }

    private static int fibo(int n) {
        // dien kien co so
        count++;
        System.out.println("start n= " + n);
        if (n <= 2) { // n==1 || n==2
            System.out.println("end n= " + n);
            return 1;
        }
        int result = fibo(n - 1) + fibo(n - 2);
        System.out.println("end n= " + n);
        return result;
    }

    private static int factorial(int n) {
        // dieu kien co so, dieu kien dung
        // diem neo
        System.out.println("start n= " + n);
        if (n == 0) {
            System.out.println("end n= " + n);
            return 1;
        }
        // cong thuc quy nap, cong thuc tong quat
        int result = n * factorial(n - 1);
        System.out.println("end n= " + n);
        return result;
        // 0!=1  // dieu kien co so
        // 1!= 1*0!
        // 2!= 2*1!
        // 3!= 3*2!
    }

    private static void doSomething() {
        int mySum = sum(1, 2);
        System.out.println(mySum);
    }

    private static int sum(int a, int b) {
        return a + b;
    }

    private static void print(int n) {
        // dieu kien dung cua de quy
        if (n > 3) {
            return;
        }
        // cong thuc truy hoi - cong thuc quy nap
        System.out.println("start: n= " + n);
        print(n + 1); // xong khi n+1=6
        System.out.println("end: n= " + n);
    }
}
