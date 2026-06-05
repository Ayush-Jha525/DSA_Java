//Q. Shift all zeros to end
//Time Complexity : O(n)
//Space Complexity : O(1)  
package Arrays;

public class ShiftZeros {
    public static void shiftZero(int[] arr) {
        if (arr.length <= 1) {
            return;
        }

        // Shifting all Non-Zero element to left
        int pos = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[pos++] = arr[i];
            }
        }

        // Adding remaining zeros
        for (int i = pos; i < arr.length; i++) {
            arr[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 0, 1, 0, 2, 0, 3, 0 };

        shiftZero(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
