/*Question : Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
* Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of  nums are not important as well as the size of nums.
* Return k.*/
//Time Complexity - O(n)
//Space Complexity - O(1)
package Arrays;

public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int idx = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                idx++;
                nums[idx] = nums[i];
            }
        }
        return idx + 1;
    }

    public static void print(int[] arr, int idx) {
        for (int i = 0; i < arr.length; i++) {
            if (i >= idx) {
                System.out.print("_");
            } else {
                System.out.print(arr[i]);
            }

            if (i < arr.length - 1) {
                System.out.print(" , ");
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 2, 2, 3, 0, 4, 2 };
        int val = 2;
        int k = nums.length - val - 1;
        System.out.println(removeElement(nums, val));
        print(nums, k);
    }
}
