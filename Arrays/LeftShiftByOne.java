//Q. Left Shift by one
//Time Complexity : O(n)
//Space Complexity : O(1)  
package Arrays;

public class LeftShiftByOne {
    public static void shiftLeft(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        int firstElement = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = firstElement;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };

        shiftLeft(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
