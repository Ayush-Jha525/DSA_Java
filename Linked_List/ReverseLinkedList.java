/*Question : Given the head of a singly linked list, reverse the list and return the new head. */
// Time Complexity : O(n)
// Space Complexity : O(1)
package Linked_List;

class Node {
    int value;
    Node next;

    Node(int val) {
        this.value = val;
        this.next = null;
    }

    Node(int val, Node newNode) {
        this.value = val;
        this.next = newNode;
    }
}

public class ReverseLinkedList {
    public static Node linkedListReverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;

            current.next = prev;

            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5)))));
        // original;
        printList(head);

        // After reverse
        head = linkedListReverse(head);
        printList(head);
        System.out.println(head.value);
    }
}
