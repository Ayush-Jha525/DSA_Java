/*Question : Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.*/
// Time Complexity :  O(log(num))
// Space Complexity : O(1)
package Math;

public class AddDigits {
    public static int sumDigit(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static int addDigits(int num) {
        while (num / 10 != 0) {
            num = sumDigit(num);
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(addDigits(0));

        System.out.println(addDigits(38));

        System.out.println(addDigits(492));
    }
}