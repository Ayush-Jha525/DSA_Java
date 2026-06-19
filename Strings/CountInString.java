//Question: Count Vowels, Consonants, Digits and Special Characters
//Time Complexity : O(n)
//Space Complexity : O(1)
package Strings;

public class CountInString {
    // check if a character is vowel or not
    public static boolean isVowel(char c) {
        String vowels = "aeiou";
        for (char i : vowels.toCharArray()) {
            if (c == i) {
                return true;
            }
        }
        return false;
    }

    public static void countString(String str) {
        int v = 0; // count vowels
        int c = 0; // count Consonants
        int d = 0; // count Digits
        int s = 0; // count Special Characters

        str = str.toLowerCase();
        for (char i : str.toCharArray()) {
            if (i >= 'a' && i <= 'z') {
                if (isVowel(i)) {
                    v++;
                } else {
                    c++;
                }
            } else if (Character.isDigit(i)) {
                d++;
            } else {
                s++;
            }
        }

        System.out.println("Vowel = " + v);
        System.out.println("Consonent = " + c);
        System.out.println("Digits = " + d);
        System.out.println("Special character = " + s);
    }

    public static void main(String[] args) {
        String str = "HelloWorld 123 @!#$";

        countString(str);
    }
}
