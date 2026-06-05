//question : Remove duplicate elements from a sorted array and return the number of unique elements.
//Time Complexity - O(n)
//Space Complexity - O(1)
package Arrays;

public class RemoveDuplicate {
    public static int removeDuplicates(int[] arr) {
        if (arr.length == 0) {
            return 0;
        } else if (arr.length == 1) {
            return 1;
        } else {
            int pos = 0;
            for (int i = 1; i < arr.length; i++) {
                if (arr[pos] != arr[i]) {
                    pos++;
                    arr[pos] = arr[i];
                }
            }
            return pos + 1;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 3, 3, 5, 5, 7, 7, 9 };

        // returns the size of non dublicate elements
        int size = removeDuplicates(arr);
        System.out.println(size);
    }
}
