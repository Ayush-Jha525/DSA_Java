//Question - Find Second Largest Element in positive array
//Time Complexity - O(n)
//Space Complexity - O(1)
package Arrays;

public class SecondLargestElement {
    public static int findSecondLargest(int[] arr) {
        if (arr.length <= 1) {
            return -1; // Return -1 when no second distinct largest element exists.
        }
        int largest = arr[0];
        int secondLargest = -1;
        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            }
            if (num > secondLargest && num < largest) {
                secondLargest = num;
            }
        }
        return secondLargest;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 2, 8, 1, 9, 12, 7 };
        System.out.println(findSecondLargest(arr));
    }
}
