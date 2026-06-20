//Question: Reverse Words in a String
// Given a string containing words separated by one or more spaces, reverse the order of the words.
//      *Remove leading and trailing spaces.
//      *Reduce multiple spaces between words to a single space in the output.
//      *Return the resulting string.
//Time Complexity : O(n)
//Space Complexity : O(n)
package Strings;

public class ReverseWords {
    public static String reverse(String line) {
        StringBuilder result = new StringBuilder();
        line = line.trim();
        String[] words = line.split("\\s+"); // splits by one or more consecutive space

        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i] + " ");
        }

        return result.toString().trim();

    }

    public static void main(String[] args) {
        String str = "this    is  a book    ";

        String result = reverse(str);
        System.out.println(result);
    }
}