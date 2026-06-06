//Q. Find Missing number in a array
//      * Array contains distinct integers.
//      * Exactly one number is missing.
//      * Numbers are in the range 1 to n.
//      * Array may be unsorted.
//Time Complexity : O(n)
//Space Complexity : O(1) 
package Arrays;

public class MissingNumber {
    public static int findMissing(int[] arr, int n) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return ((n * (n + 1)) / 2) - sum;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 5 };
        System.out.println(findMissing(arr, 5));
    }
}
