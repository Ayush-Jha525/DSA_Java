/*Question : You are given the head of a singly linked-list. The list can be represented as:
        L0 → L1 → … → Ln - 1 → Ln

Reorder the list to be on the following form:
        L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
        
You may not modify the values in the list's nodes. Only nodes themselves may be changed. */
//Time Complexity: O(n)
//Space Complexity: O(1)
package Linked_List;

public class ReorderList {
    public static Node findMid(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;

            current.next = prev;

            prev = current;
            current = next;
        }
        return prev;
    }

    public static void reorder(Node head) {
        if (head == null || head.next == null) {
            return;
        }

        Node mid = findMid(head);
        Node newHead = reverseList(mid.next);
        mid.next = null;

        Node firstHalf = head;
        Node secondHalf = newHead;

        while (secondHalf != null) {
            Node firstNext = firstHalf.next;

            firstHalf.next = secondHalf;
            secondHalf = secondHalf.next;

            firstHalf.next.next = firstNext;

            firstHalf = firstNext;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, new Node(6))))));

        reorder(head);

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("Null");

    }
}
