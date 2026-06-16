//Question: Given an array of integers containing an equal number of positive and negative numbers, rearrange the array so that positive and negative numbers appear alternately, starting with a positive number.
//  The relative order of positive numbers among themselves and negative numbers among themselves should be preserved.
//Time Complexity : O(n)
//Space Complexity : O(n) 
package Arrays;

public class RearrangeArraybySign {
    public static void arrangeBySign(int[] arr) {
        int[] positive = new int[arr.length / 2];
        int p = 0;
        int[] negative = new int[arr.length / 2];
        int n = 0;

        for (int i : arr) {
            if (i < 0) {
                negative[n++] = i;
            } else {
                positive[p++] = i;
            }
        }
        p = n = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                arr[i] = positive[p++];
            } else {
                arr[i] = negative[n++];
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, -2, -5, 2, -4 };
        arrangeBySign(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
