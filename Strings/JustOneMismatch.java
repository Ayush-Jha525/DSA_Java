/*Question : Given a string s and an array of strings arr[], find if any string in arr[] of the same length as s differs from it at exactly one position.  */
//Time Complexity : O(n)
//Space Complexity : O(1)
package Strings;

public class JustOneMismatch {
    public static boolean isStringExist(String s, String[] arr) {
        // code here
        for (String i : arr) {
            if (i.length() == s.length()) {
                int count = 0;
                for (int j = 0; j < i.length(); j++) {
                    if (i.charAt(j) != s.charAt(j)) {
                        count++;
                    }
                }
                if (count == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] arr = { "bana", "apple", "banaba", "bonaba" };
        String s = "banana";

        System.out.println(isStringExist(s, arr));
    }
}
