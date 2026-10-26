/*Question : Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.*/
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
