//Question : Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
// Time Complexity :  O(√x)
// Space Complexity : O(1)
package Math;

public class Sqrt {
    public static int mySqrt(int x) {
        int i = 1;
        while (i <= x / i) {
            if (i == x / i) {
                return i;
            }
            i++;
        }
        return i - 1;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(4)); // Output: 2

        System.out.println(mySqrt(8)); // Output: 2

        System.out.println(mySqrt(25)); // Output: 5
    }
}
