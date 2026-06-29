//Question : Given the array nums after the possible rotation and an integer target, return true if it is in nums, or false if it is not in nums.
//    (Array may contain duplicate values)
//Time Complexity : O(log n) average , O(n) worst case
//Space Complexity : O(1)
package Arrays;

public class SearchInRotatedSortedArrayII {
    public static boolean searchArray(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return true;
            }
            // For duplicate numbers
            if (arr[start] == arr[mid] && arr[mid] == arr[end]) {
                start++;
                end--;
                continue;
            }

            if (arr[start] <= arr[mid]) {
                if (target >= arr[start] && target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > arr[mid] && target <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr1 = { 2, 5, 6, 0, 0, 1, 2 };
        int[] arr2 = { 1, 1, 1, 1, 1, 0, 1, 1 };

        System.out.println(searchArray(arr1, 3));

        System.out.println(searchArray(arr2, 0));
    }
}
