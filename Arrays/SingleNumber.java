/*Question : Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.*/
//Time Complexity - O(n)
//Space Complexity - O(1)
package Arrays;

public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int i : nums) {
            result ^= i;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 1, 2, 1, 2 };
        System.out.println(singleNumber(nums));

        nums = new int[] { 2, 2, 1 };
        System.out.println(singleNumber(nums));
    }
}
