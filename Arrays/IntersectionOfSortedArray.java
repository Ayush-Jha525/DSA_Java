//Question - Given two sorted arrays, return an array containing all common elements present in both arrays.
//Time Complexity - O(n+m)                      n : length of arr1
//Space Complexity - O(min(n,m))                 m : length of arr2
package Arrays;

public class IntersectionOfSortedArray {
    public static int[] intersectingElement(int[] arr1, int[] arr2) {
        if (arr1.length == 0 || arr2.length == 0) {
            return new int[] {};
        }
        int[] result = new int[Math.min(arr1.length, arr2.length)];
        int idx = 0, i = 0, j = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else {
                if (idx == 0 || result[idx - 1] != arr1[i]) {
                    result[idx++] = arr1[i];
                }
                i++;
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

        int[] result = intersectingElement(arr1, arr2);

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
