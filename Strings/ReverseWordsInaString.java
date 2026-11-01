/*Question : Given an input string s, reverse the order of the words.
A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
Return a string of the words in reverse order concatenated by a single space.
Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.*/
//Time Complexity : O(n) 
//Space Complexity : O(n)
package Strings;

public class ReverseWordsInaString {
    public static String reverseWords(String s) {
        StringBuilder reverse = new StringBuilder();
        String[] arr = s.split("\\s+");

        for (int i = arr.length - 1; i >= 0; i--) {
            if (!arr[i].isEmpty()) {
                reverse.append(arr[i]).append(" ");
            }
        }

        if (reverse.length() > 0) {
            reverse.setLength(reverse.length() - 1);
        }
        return reverse.toString();
    }

    public static void main(String[] args) {
        String s1 = "a good   example";
        System.out.println(reverseWords(s1));

        String s2 = "Hello    World!  This is   a program";
        System.out.println(reverseWords(s2));
    }
}
