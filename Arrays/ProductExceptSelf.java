//Question: Given an integer array, return an array answer such that answer[i] is equal to the product of all the elements of the array except arr[i].
//You must not use division, and the solution should run in linear time.
//Time Complexity : O(n)
//Space Complexity : O(1)   (excluding the output array)
package Arrays;

public class ProductExceptSelf {
    public static int[] product(int[] arr) {
        if (arr.length == 1) {
            return new int[] { 1 };
        }
        int[] result = new int[arr.length];

        int prefix = 1;
        // left product
        for (int i = 0; i < arr.length; i++) {
            result[i] = prefix;
            prefix *= arr[i];
        }

        // right product
        int suffix = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            result[i] *= suffix;
            suffix *= arr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { -1, 1, 0, -3, 3 };

        int[] result = product(arr);

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
