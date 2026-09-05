/*Question : You are given the head of a singly linked list, you have to right rotate the linked list k times. Return the head of the modified linked list. */
//Time Complexity: O(n)
//Space Complexity: O(1)
package Linked_List;

public class RotateRight {
    public static Node rotate(Node head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }

        Node temp = head;
        int n = 1;
        while (temp.next != null) {
            n++;
            temp = temp.next;
        }

        int target = n - (k % n);

        if (target == n) {
            return head;
        }

        temp.next = head;

        Node cur = head;
        while (target > 1) {
            cur = cur.next;
            target--;
        }
        head = cur.next;
        cur.next = null;

        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        head = rotate(head, 2);

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }
}
