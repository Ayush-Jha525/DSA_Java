//Question - You have a array of integers s, which originally contains all the numbers from 1 to n and one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number. find that number
package Arrays;

import java.util.*;

public class MissingNumber_II {

    // Approach 1 : using HashSet
    // Time Complexity - O(n)
    // Space Complexity - O(n)
    public static int[] findNumber(int[] s) {
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
        int duplicate = -1;

        for (int i : s) {
            if (set.add(i)) { // add method returns if added sucessfully and return false if already exist in
                              // the set
                sum += i;
            } else {
                duplicate = i;
            }
        }
        int n = s.length;
        int totalSum = (n * (n + 1)) / 2;
        return new int[] { duplicate, totalSum - sum };
    }

    // Approach 2 : Using negative index marking
    // Time Complexity - O(n)
    // Space Complexity - O(1)
    public static int[] findNumber1(int[] s) {
        int sum = 0;
        int duplicate = -1;

        for (int i = 0; i < s.length; i++) {
            int num = Math.abs(s[i]);
            int idx = num - 1;
            if (s[idx] < 0) { // if value at idx is negative then current element is duplicate
                duplicate = num;
            } else {
                sum += num;
                s[idx] *= -1; // mark negative for visited element
            }
        }
        int n = s.length;
        int totalSum = (n * (n + 1)) / 2;
        return new int[] { duplicate, totalSum - sum };
    }

    public static void main(String[] args) {
        int[] arr = { 7, 2, 3, 4, 1, 5, 5 }; // expected output : 5 6

        int[] result = findNumber(arr);
        System.out.println(result[0] + " " + result[1]);

        int[] result1 = findNumber1(arr);
        System.out.println(result1[0] + " " + result1[1]);

    }
}
