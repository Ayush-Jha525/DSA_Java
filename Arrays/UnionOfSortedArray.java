//Question - Given two sorted arrays, return a sorted array containing all distinct elements present in either array.
//Time Complexity - O(n+m)                  n : length of arr1
//Space Complexity - O(n+m)                 m : length of arr2
package Arrays;

public class UnionOfSortedArray {
    public static int[] union(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int idx = 0; // idx : track result
        int i = 0, j = 0; // i : track arr1 & j : track arr2

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                if (idx == 0 || result[idx - 1] != arr1[i]) {
                    result[idx++] = arr1[i++];
                } else {
                    i++;
                }
            } else {
                if (idx == 0 || result[idx - 1] != arr2[j]) {
                    result[idx++] = arr2[j++];
                } else {
                    j++;
                }
            }
        }

        while (i < arr1.length) {
            if (idx == 0 || result[idx - 1] != arr1[i]) {
                result[idx++] = arr1[i++];
            } else {
                i++;
            }
        }
        while (j < arr2.length) {
            if (idx == 0 || result[idx - 1] != arr2[j]) {
                result[idx++] = arr2[j++];
            } else {
                j++;
            }
        }

        int[] finalResult = new int[idx];
        for (int k = 0; k < idx; k++) {
            finalResult[k] = result[k];
        }
        return finalResult;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 2, 2, 2, 3, 5 };
        int[] arr2 = { 2, 3, 5, 8 };

        int[] result = union(arr1, arr2);

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
