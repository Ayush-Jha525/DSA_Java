/*Question : Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
Return the running sum of nums.*/
//Time Complexity : O() 
//Space Complexity : O()
package Arrays;

public class RunningSumof1dArray {
    public static int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            result[i] = sum;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, 2, 10, 1 };
        int[] result = runningSum(nums);

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
