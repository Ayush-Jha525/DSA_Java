//Question : Given an array, reverse all its elements in-place and return/print the reversed array.
//Time Complexity : O(n);
//Space Complexity : O(1);
package Arrays;

public class ReverseArray {
    public static void reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        reverse(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
