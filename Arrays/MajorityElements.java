//Question: Given an array of integers, find the element that appears more than n/2 times. If no such element exists, return -1.
//Time Complexity : O(n)
//Space Complexity : O(1)
package Arrays;

public class MajorityElements {
    public static int majorityEle(int[] arr) {
        // Approach using Moore's Voting algorithm
        if (arr.length == 0) {
            return -1;
        }
        int candidate = arr[0];
        int vote = 1; // for candidate arr[0]
        for (int i = 1; i < arr.length; i++) {
            if (vote == 0) {
                candidate = arr[i];
                vote = 1;
            } else if (candidate == arr[i]) {
                vote++;
            } else {
                vote--;
            }
        }

        // checking if candidate is majority or not
        int count = 0;
        for (int i : arr) {
            if (candidate == i) {
                count++;
            }
        }

        if (count > arr.length / 2) {
            return candidate;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 3, 4, 2, 2, 2 };

        System.out.println(majorityEle(arr));
    }
}