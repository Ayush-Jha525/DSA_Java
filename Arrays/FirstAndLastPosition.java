//Question : Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
//      If target is not found in the array, return [-1, -1].
//      You must write an algorithm with O(log n) runtime complexity.
//Time Complexity : O(log n)
//Space Complexity : O(1)
package Arrays;

public class FirstAndLastPosition {
    public static int[] findPosition(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int startIdx = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] < target) {
                start = mid + 1;
            } else {
                if (arr[mid] == target) {
                    startIdx = mid;
                }
                end = mid - 1;
            }
        }

        start = 0;
        end = arr.length - 1;
        int endIdx = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > target) {
                end = mid - 1;
            } else {
                if (arr[mid] == target) {
                    endIdx = mid;
                }
                start = mid + 1;
            }
        }
        return new int[] { startIdx, endIdx };
    }

    public static void main(String[] args) {
        int[] arr = { 5, 7, 7, 8, 8, 10 };
        int[] result = findPosition(arr, 8);
        System.out.println(result[0] + " " + result[1]);
    }
}
