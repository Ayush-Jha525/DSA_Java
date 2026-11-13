/*Question : Given an integer n, return true if it is a power of two. Otherwise, return false.

An integer n is a power of two, if there exists an integer x such that n == 2^x.*/
// Time Complexity :  O(1)
// Space Complexity : O(1)
package Math;

public class PowerofTwo {
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(0)); // output : false
        System.out.println(isPowerOfTwo(1)); // output : true

        System.out.println(isPowerOfTwo(13)); // output : false
        System.out.println(isPowerOfTwo(8)); // output : true
        System.out.println(isPowerOfTwo(36)); // output : false
    }
}
