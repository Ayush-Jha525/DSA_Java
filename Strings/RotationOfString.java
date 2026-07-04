//Question : Given two strings s and goal, determine whether goal is a rotation of s
//Time Complexity : O(n)
//Space Complexity : O(n)
package Strings;

public class RotationOfString {
    public static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        String newString = s + s;
        return newString.contains(goal);
    }

    public static void main(String[] args) {
        String s = "abcde";
        String goal = "cdeab";

        System.out.println(rotateString(s, goal));
    }
}
