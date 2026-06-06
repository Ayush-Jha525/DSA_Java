//Question: Given a binary array (containing only 0s and 1s), find the maximum number of consecutive 1s present in the array.
// Constraints:
//  1 <= array length
//  Array elements are either 0 or 1
//Time Complexity : O(n)
//Space Complexity : O(1) 
package Arrays;

public class MaxConsecutive1s {
    public static int max1s(int[] arr) {
        int maxOnes = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count += 1;
                maxOnes = Math.max(maxOnes, count);
            } else {
                count = 0;
            }
        }
        return maxOnes;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 0, 1, 1, 1 };
        System.out.println(max1s(arr));
    }
}
