/*Question : Given a string s, return the string after replacing every uppercase letter with the same lowercase letter.*/
//Time Complexity : O(n) 
//Space Complexity : O(n)
package Strings;

public class ToLowerCase {
    public static String toLowerCase(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                result.append((char) (c + 32));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "Hello";
        System.out.println(toLowerCase(s)); // Output: "hello"

        s = "here";
        System.out.println(toLowerCase(s)); // Output: "here"

        s = "LOVELY";
        System.out.println(toLowerCase(s)); // Output: "lovely"

        s = "al&phaBET";
        System.out.println(toLowerCase(s)); // Output: "al&phabet"
    }
}
