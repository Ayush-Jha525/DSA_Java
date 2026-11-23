/*Question : Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.*/
//Time Complexity - O(log(n))
//Space Complexity - O(1)
package Arrays;

public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 6 };
        int target = 5;
        System.out.println(searchInsert(nums, target));

        nums = new int[] { 1, 3, 5, 6 };
        target = 2;
        System.out.println(searchInsert(nums, target));
    }
}
