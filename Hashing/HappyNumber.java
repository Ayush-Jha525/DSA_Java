//Question: A happy number is defined by the following process:
//   Starting with any positive integer, replace the number by the sum of the squares of its digits.
//   Repeat the process until:
//   the number becomes 1, or
//   it enters a cycle that will never reach 1.
//   Return true if the number is happy, otherwise return false.
//Time Complexity : O(log n)
//Space Complexity : O(log n) 
package Hashing;

import java.util.HashSet;

public class HappyNumber {

    public static boolean isHappy(int n) {
        HashSet<Integer> visited = new HashSet<>();

        while (visited.add(n)) {
            int sum = 0;
            while (n != 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }

            if (sum == 1) {
                return true;
            }
            n = sum;
        }
        return false;
    }

    public static void main(String[] args) {
        int num1 = 19;
        int num2 = 4;

        System.out.println(isHappy(num1));
        System.out.println(isHappy(num2));
    }
}
