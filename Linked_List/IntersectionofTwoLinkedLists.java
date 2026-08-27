/*Question : Given the heads of two singly linked lists, determine the node at which the two lists intersect.
The intersection means the same actual node, not merely two nodes having the same value. */
//Time Complexity:  O(n + m)
//Space Complexity: O(1)

package Linked_List;

public class IntersectionofTwoLinkedLists {
    public static Node getIntersectionNode(Node headA, Node headB) {
        Node head1 = headA;
        while (head1.next != null) {
            head1 = head1.next;
        }
        head1.next = headB;

        Node slow = headA;
        Node fast = headA;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = headA;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                head1.next = null;
                return slow;
            }
        }
        head1.next = null;
        return null;
    }

    public static void main(String[] args) {
        // first list: 10 -> 15 -> 30
        Node head1 = new Node(10);
        head1.next = new Node(15);
        head1.next.next = new Node(30);

        // second list: 3 -> 6 -> 9 -> 15 -> 30
        Node head2 = new Node(3);
        head2.next = new Node(6);
        head2.next.next = new Node(9);

        // 15 is the intersection point
        head2.next.next.next = head1.next;

        Node intersect = getIntersectionNode(head1, head2);

        System.out.println(intersect.value);
    }
}
