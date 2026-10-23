/*Question : You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.
You are given an integer array nums representing the data status of this set after the error.
Find the number that occurs twice and the number that is missing and return them in the form of an array.*/
//Time Complexity : O(n) 
//Space Complexity : O(1)
package Arrays;

public class SetMismatch {
    public static int[] findErrorNums(int[] nums) {
        int sum = 0;
        int duplicate = -1;

        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] < 0) {
                duplicate = nums[i] * -1;
            } else {
                sum += nums[i];
                nums[idx] *= -1;
            }
        }
        int n = nums.length;
        int totalSum = (n * (n + 1)) / 2;
        return new int[] { duplicate, totalSum - sum };
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 5, 5 };
        int[] result = findErrorNums(nums);

        System.out.println(result[0] + " " + result[1]);
    }
}
