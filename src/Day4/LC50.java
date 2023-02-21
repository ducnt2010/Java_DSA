package Day4;

public class LC50 {

    public static void main(String[] args) {
        System.out.println(myPow(2, 10));
    }
//    x =
//            2.00000
//    n =
//            -2147483648  = -2^-31 ->2^-31
    // max int = 2^-31 -1

    // 2^-2
    public static double myPow(double x, int n) {
        return powww(x, n);
    }

    private static double powww(double x, long n) {
        if (x == 0 || x == 1) {
            return x;
        }
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            x = 1 / x;  // 2 -> 1/2
            n = -n;
        }
        if (n % 2 == 0) {
            return powww(x * x, n / 2);
        }
        return x * powww(x * x, n / 2);
    }


}
