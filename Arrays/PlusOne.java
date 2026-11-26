/*Question : You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
Increment the large integer by one and return the resulting array of digits.*/
//Time Complexity - O(n)
//Space Complexity - O(1)
package Arrays;

public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int[] arr;
        boolean extrasizeneed = true;

        for (int i : digits) {
            if (i != 9) {
                extrasizeneed = false;
                break;
            }
        }

        if (extrasizeneed) {
            arr = new int[digits.length + 1];
        } else {
            arr = new int[digits.length];
        }

        int carry = 1;
        int idx = arr.length - 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            arr[idx] = sum % 10;
            carry = sum / 10;
            idx--;
        }
        if (extrasizeneed) {
            arr[0] = 1;
        }

        return arr;
    }

    public static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] digits = { 4, 3, 2, 1, 9 };
        digits = plusOne(digits);
        print(digits);

        digits = new int[] { 9, 9 };
        digits = plusOne(digits);
        print(digits);
    }
}
