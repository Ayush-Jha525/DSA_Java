//Question : Given the head of a linked list and an integer value, remove every node whose value equals value, and return the new head.
//Time Complexity:  O(n)
//Space Complexity: O(1)
package Linked_List;

class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
        next = null;
    }

    Node(int value, Node nextvalue) {
        this.value = value;
        next = nextvalue;
    }
}

public class RemoveLinkedListElements {
    public static Node removeNodes(Node head, int target) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;
        Node current = head;
        while (current != null) {
            if (current.value == target) {
                prev.next = current.next;
            } else {
                prev = current;
            }
            current = current.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Node list = new Node(1, new Node(2, new Node(3, new Node(2, new Node(4)))));
        int target = 2;
        Node sorted = removeNodes(list, target);

        while (sorted != null) {
            System.out.print(sorted.value + " -> ");
            sorted = sorted.next;
        }
        System.out.println("Null");
    }
}
