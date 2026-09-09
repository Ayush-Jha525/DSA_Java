/*Question : Given the head of a linked list, return the list after sorting it in ascending order. */
//Time Complexity: O(n log n)
//Space Complexity: O(n)
package Linked_List;

public class SortList {
    public static Node sortList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        // middle node
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Splitting the list
        Node rightHead = slow.next;
        slow.next = null;

        // Sorting both halves
        Node left = sortList(head);
        Node right = sortList(rightHead);

        // Merging sorted halves
        return merge(left, right);
    }

    private static Node merge(Node left, Node right) {

        Node dummy = new Node(0);
        Node temp = dummy;

        while (left != null && right != null) {

            if (left.value <= right.value) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }

            temp = temp.next;
        }

        // Attaching remaining nodes
        if (left != null) {
            temp.next = left;
        } else {
            temp.next = right;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Node head = new Node(1, new Node(5, new Node(6, new Node(4, new Node(2, new Node(3))))));

        sortList(head);
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }
}
