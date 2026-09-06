/*Question : Given the head of a linked list and an integer x, partition the list so that:
        * All nodes with valueues less than x come before nodes with valueues greater than or equal to x.
        * The relative order of nodes within each group must remain the same. */
//Time Complexity: O(n)
//Space Complexity: O(1)
package Linked_List;

public class PartitionList {
    public static Node partition(Node head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        Node smaller = new Node(0);
        Node small = smaller;
        Node larger = new Node(0);
        Node large = larger;
        Node temp = head;
        while (temp != null) {
            Node next = temp.next;
            temp.next = null;
            if (temp.value < x) {
                small.next = temp;
                small = small.next;
            } else {
                large.next = temp;
                large = large.next;
            }
            temp = next;
        }
        small.next = larger.next;
        return smaller.next;
    }

    public static void main(String[] args) {
        // Creating the linked list: 1 -> 4 -> 3 -> 2 -> 5 -> 2
        Node head = new Node(1);
        head.next = new Node(4);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(2);
        int x = 3;
        head = partition(head, x);

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }
}
