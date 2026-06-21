//Question: Given an array of strings, find the longest common prefix shared among all the strings.
//          If there is no common prefix, return an empty string ""
//Time Complexity : O(n+m)  * n = number of strings
//                          * m = length of the shortest prefix being compared
//Space Complexity : O(m)
package Strings;

public class LongestCommonPrefix {
    public static String longestPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        StringBuilder prefix = new StringBuilder(strs[0]);

        for (int i = 1; i < strs.length; i++) {
            String current = strs[i];

            if (prefix.length() > current.length()) {
                prefix.delete(current.length(), prefix.length());
            }

            for (int j = 0; j < prefix.length(); j++) {
                if (current.charAt(j) != prefix.charAt(j)) {
                    prefix.delete(j, prefix.length());
                    break;
                }
            }
            if (prefix.isEmpty()) {
                return "";
            }
        }
        return prefix.toString();
    }

    public static void main(String[] args) {
        String[] strs = { "flower", "flow", "flight" };

        System.out.println(longestPrefix(strs));
    }
}