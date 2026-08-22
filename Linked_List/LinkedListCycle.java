/*Question : Given the head of a linked list, determine whether the linked list contains a cycle.
    A cycle exists if, by repeatedly following next, you eventually reach a node that you've already visited. */
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
}

public class LinkedListCycle {
    public static boolean hasCycle(Node head) {
        if (head == null) {
            return false;
        }

        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(4);

        head.next.next.next = head.next;

        System.out.println(hasCycle(head));

    }
}
