/*Question : Given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each node contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the numbers do not contain leading zeros, except for the number 0. */
//Time Complexity :  O(max(n, m))
//Space Complexity:   O(max(n, m))
package Linked_List;

public class AddTwoNumbers {
    public static Node addTwoNumber(Node l1, Node l2) {
        Node result = new Node(0);
        Node current = result;
        int carry = 0;
        Node number1 = l1;
        Node number2 = l2;

        while (number1 != null || number2 != null) {
            int num1 = (number1 != null) ? number1.value : 0;
            int num2 = (number2 != null) ? number2.value : 0;

            int sum = num1 + num2 + carry;

            current.next = new Node(sum % 10);

            carry = sum / 10;

            number1 = (number1 != null) ? number1.next : null;
            number2 = (number2 != null) ? number2.next : null;
            current = current.next;
        }

        if (carry > 0) {
            current.next = new Node(carry);
        }
        return result.next;
    }

    public static void main(String[] args) {
        Node num1 = new Node(1, new Node(2, new Node(3)));
        Node num2 = new Node(5, new Node(4, new Node(1)));

        Node result = addTwoNumber(num1, num2);
        Node temp = result;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }
}
