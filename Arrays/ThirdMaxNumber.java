/*You are given an integer array nums.
Return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number. */
//Time Complexity : O(n)
//Space Complexity : O(1)
package Arrays;

public class ThirdMaxNumber {
    public static int thirdMax(int[] nums) {
        long firstMaximum = Long.MIN_VALUE;
        long secondMaximum = Long.MIN_VALUE;
        long thirdMaximum = Long.MIN_VALUE;
        for (int i : nums) {
            if (i == firstMaximum || i == secondMaximum || i == thirdMaximum) {
                continue;
            }

            if (i > firstMaximum) {
                thirdMaximum = secondMaximum;
                secondMaximum = firstMaximum;
                firstMaximum = i;
            } else if (i > secondMaximum) {
                thirdMaximum = secondMaximum;
                secondMaximum = i;
            } else if (i > thirdMaximum) {
                thirdMaximum = i;
            }
        }
        return (thirdMaximum == Long.MIN_VALUE) ? (int) firstMaximum : (int) thirdMaximum;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 4, 1, 3, 5 };
        System.out.println(thirdMax(arr));
    }
}
