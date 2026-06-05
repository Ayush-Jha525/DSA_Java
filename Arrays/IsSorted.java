//Question - Array is Sorted or not
//Time Complexity - O(n)
//Space Complexity - O(1)
package Arrays;

public class IsSorted {
    public static boolean isSorted(int[] arr) {
        if (arr.length <= 1) {
            return true;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = { 5, 2, 8, 1, 9, 12, 7 };
        int[] arr2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        System.out.println(isSorted(arr1));
        System.out.println(isSorted(arr2));
    }
}
