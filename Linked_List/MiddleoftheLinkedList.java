/*Question : Given the head of a singly linked list, return the middle node.
    If there are two middle nodes, return the second middle node. */
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

public class MiddleoftheLinkedList {
    public static Node middleNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, new Node(6))))));
        Node mid = middleNode(head);
        System.out.println(mid.value);
    }
}
