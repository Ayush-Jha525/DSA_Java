/*Question : Implement pow(x, n), which calculates x raised to the power n (i.e., x^n).*/
// Time Complexity :  O(log(n))
// Space Complexity : O(1)
package Math;

public class PowOfXandN {
    public static double myPow(double x, int n) {
        long N = n;
        boolean isNegative = false;

        if (N < 0) {
            isNegative = true;
            N = -N;
        }

        double result = 1.0;

        while (N > 0) {
            if (N % 2 == 1) {
                result *= x;
            }
            x *= x;
            N /= 2;
        }

        return isNegative ? (1.0 / result) : result;
    }

    public static void main(String[] args) {
        double x = -0.9999999968539456;
        int n = -1669585506;
        System.out.println(myPow(x, n)); // Expected Opt : 191.06370

        x = 2.00000;
        n = -2;
        System.out.println(myPow(x, n)); // Expected Opt : 0.25000

        x = 2.00000;
        n = 10;
        System.out.println(myPow(x, n)); // Expected Opt : 1024.00000
    }
}
