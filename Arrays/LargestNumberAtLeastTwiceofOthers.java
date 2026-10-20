/*Question : You are given an integer array nums where the largest integer is unique.
Determine whether the largest element in the array is at least twice as much as every other number in the array. If it is, return the index of the largest element, or return -1 otherwise.*/
//Time Complexity : O(n) 
//Space Complexity : O(1)
package Arrays;

public class LargestNumberAtLeastTwiceofOthers {
    public static int dominantIndex(int[] nums) {
        int largest = -1;
        int secondLargest = -1;
        int largestIdx = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > largest) {
                secondLargest = largest;
                largest = nums[i];
                largestIdx = i;
            } else if (nums[i] > secondLargest) {
                secondLargest = nums[i];
            }
        }
        return (largest >= 2 * secondLargest) ? largestIdx : -1;
    }

    public static void main(String[] args) {
        int[] nums1 = { 3, 6, 1, 0 };
        int[] nums2 = { 1, 2, 3, 4 };

        System.out.println(dominantIndex(nums1)); // Output : 1
        System.out.println(dominantIndex(nums2)); // Output : -1
    }
}
