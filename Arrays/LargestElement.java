//Question - Find Largest Element in array
//Time Complexity - O(n)
//Space Complexity - O(1)
package Arrays;

public class LargestElement {
    public static int findLargest(int[] arr) {
        if (arr.length == 0) {
            return -1; // return -1 if array is empty or no larger element present
        }

        // Assuming first element is the largest
        int largest = arr[0];
        for (int num : arr) {
            if (num > largest) {
                largest = num;
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 2, 8, 1, 9, 12, 7 };
        System.out.println(findLargest(arr));
    }
}