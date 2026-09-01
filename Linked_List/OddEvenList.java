/*Question: Given the head of a singly linked list, group all nodes at odd indices together followed by all nodes at even indices, while maintaining their original relative order.
Important: indices start from 1, not the node values.*/
//Time Complexity:  O(n)
//Space Complexity: O(1)
package Linked_List;

public class OddEvenList {
    public static Node oddEvenList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node even = head.next;

        Node tempOdd = head;
        Node tempEven = even;

        while (tempOdd.next != null && tempEven.next != null) {
            tempOdd.next = tempEven.next;
            tempOdd = tempOdd.next;

            tempEven.next = tempOdd.next;
            tempEven = tempEven.next;
        }

        tempOdd.next = even;
        if (tempEven != null) {
            tempEven.next = null;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, new Node(6))))));

        Node newHead = oddEvenList(head);
        Node temp = newHead;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }
}
