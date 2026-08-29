//Question : Given the head of a linked list, remove the nth node from the end of the list and return its head.
// Time Complexity : O(n)
// Space Complexity : O(1)
package Linked_List;

public class RemoveNthNodeFromLast {
    public static Node removeNthNode(Node head, int n) {
        if (head == null) {
            return head;
        }

        Node dummy = new Node(0);
        dummy.next = head;

        Node fast = dummy;
        Node slow = dummy;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        // Linked list : 1->2->3->4->5
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5)))));

        Node temp = removeNthNode(head, 2);

        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }
}
