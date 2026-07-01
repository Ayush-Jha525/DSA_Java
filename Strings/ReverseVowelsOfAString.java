package Strings;

public class ReverseVowelsOfAString {
    public static boolean isVowel(char c) {
        if (c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u'
                || c == 'U') {
            return true;
        }
        return false;
    }

    public static String reverseVowels(String s) {
        StringBuilder result = new StringBuilder(s);
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (!isVowel(result.charAt(i))) {
                i++;
                continue;
            }
            if (!isVowel(result.charAt(j))) {
                j--;
                continue;
            }
            char temp = result.charAt(i);
            result.setCharAt(i, result.charAt(j));
            result.setCharAt(j, temp);
            i++;
            j--;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "IceCreAm";
        s = reverseVowels(s);
        System.out.println(s);
    }
}
