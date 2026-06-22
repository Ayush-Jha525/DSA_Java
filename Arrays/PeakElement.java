//Question: Find Peak Element
//   A peak element is an element that is strictly greater than its neighbors.
//Time Complexity: O(log n)
//Space Complexity: O(1)
package Arrays;

public class PeakElement {
    public static int findPeak(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 1, 3, 5, 6, 4 }; // output : 5 (index of 6 is 5)

        System.out.println(findPeak(arr));
    }
}
