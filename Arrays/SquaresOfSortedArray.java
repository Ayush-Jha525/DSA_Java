/*Question : You are given an integer array nums where the largest integer is unique.
Determine whether the largest element in the array is at least twice as much as every other number in the array. If it is, return the index of the largest element, or return -1 otherwise.*/
//Time Complexity : O(n) 
//Space Complexity : O(n)
package Arrays;

public class SquaresOfSortedArray {
    public static int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
        }
        int j = 0, k = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[j] > nums[k]) {
                result[i] = nums[j++];
            } else {
                result[i] = nums[k--];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { -7, -3, 2, 3, 11 };
        int[] result = sortedSquares(nums);

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
