/*Question : Given a string s consisting of words and spaces, return the length of the last word in the string.
A word is a maximal substring consisting of non-space characters only.*/
//Time Complexity : O(n) 
//Space Complexity : O(1)
package Strings;

public class LengthofLastWord {
    public static int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        int size = 0;

        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        while (i >= 0 && s.charAt(i) != ' ') {
            size++;
            i--;
        }
        return size;
    }

    public static void main(String[] args) {
        String s1 = "   fly me   to   the moon  ";
        System.out.println(lengthOfLastWord(s1)); // Output: 4

        String s2 = "luffy is still joyboy";
        System.out.println(lengthOfLastWord(s2)); // Output: 6
    }
}
