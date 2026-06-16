//Question: Given an array containing only 0s, 1s, and 2s, sort the array in ascending order without using any built-in sorting algorithm.
//Time Complexity : O(n)
//Space Complexity : O(1) 
package Arrays;

public class Sort0s1s2s {
    // using Duch National Flag algorithm
    public static void sort(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {
            int temp;
            if (arr[mid] == 0) {
                temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 2, 2, 2, 1, 0, 0 };

        sort(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
