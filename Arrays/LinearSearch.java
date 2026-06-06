//Q. Linear Search  
//Time Complexity : O(n)
//Space Complexity : O(1) 
package Arrays;

public class LinearSearch {
    // Return index if found otherwise return -1
    public static int linearSearch(int[] arr, int val) {
        for (int i = 0; i < arr.length; i++) {
            if (val == arr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 5, 3, 6, 8, 4 };
        int[] arr2 = {};
        System.out.println(linearSearch(arr2, 3));
        System.out.println(linearSearch(arr, 9));
        System.out.println(linearSearch(arr, 3));
    }
}
