//Q. Left rotate by k element
//Time Complexity : O(n)
//Space Complexity : O(1) 

package Arrays;

public class LeftRotateByK {
    // Reverse range = [start, end)
    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end - 1];
            arr[end - 1] = temp;
            start++;
            end--;
        }
    }

    public static void leftRotate(int[] arr, int k) {
        if (arr.length <= 1) {
            return;
        }
        k = k % arr.length;

        // Rotate first k-1 element
        reverse(arr, 0, k);

        // Rotating remaining elements
        reverse(arr, k, arr.length);

        // Rotating entire Array
        reverse(arr, 0, arr.length);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
        leftRotate(arr, 15);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
