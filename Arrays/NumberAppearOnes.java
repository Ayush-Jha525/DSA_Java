//Question: Every element appears exactly twice except one element, which appears only once. Find that element.
//Time Complexity : O(n)
//Space Complexity : O(1) 
package Arrays;

public class NumberAppearOnes {
    public static int findNumber(int[] arr) {
        // Return -1 if no element present
        if (arr.length == 0) {
            return -1;
        }
        // Xor of (n ^ n = 0)same number cancels each other so single element remains
        int result = 0;
        for (int i : arr) {
            result = result ^ i;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 1, 2, 5, 2, 5 };
        System.out.println(findNumber(arr));
    }
}
