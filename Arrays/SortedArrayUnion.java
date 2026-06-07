//Question - Merge two sorted arrays (duplicate elements can exist in merge)
//Time Complexity - O(n+m)                  n : length of arr1
//Space Complexity - O(n+m)                 m : length of arr2
package Arrays;

public class SortedArrayUnion {
    public static int[] merge(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int idx = 0; // idx : track result
        int i = 0, j = 0; // i : track arr1 & j : track arr2

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                result[idx++] = arr1[i++];
            } else {
                result[idx++] = arr2[j++];
            }
        }

        while (i < arr1.length) {
            result[idx++] = arr1[i++];
        }
        while (j < arr2.length) {
            result[idx++] = arr2[j++];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 3, 5, 7, 9 };
        int[] arr2 = { 2, 4, 6, 8 };

        int[] merge = merge(arr1, arr2);

        for (int i : merge) {
            System.out.print(i + " ");
        }
    }
}
