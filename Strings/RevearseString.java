//Question: Given a string, reverse all its characters and return the reversed string.
//Time Complexity : O(n)
//Space Complexity : O(n)
package Strings;

public class RevearseString {
    public static String reverse(String str) {
        StringBuilder reverse = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reverse.append(str.charAt(i));
        }
        return reverse.toString();
    }

    public static void main(String[] args) {
        String str = "Hello World";
        System.out.println(reverse(str));
    }
}
