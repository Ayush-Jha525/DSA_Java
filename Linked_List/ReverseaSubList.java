/*Question : Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list. */
//Time Complexity: O(n)
//Space Complexity: O(1)

package Linked_List;

public class ReverseaSubList {
    public static Node reverseBetween(int left, int right, Node head) {
        // code here
        if (head == null || head.next == null) {
            return head;
        }
        Node dummy = new Node(0);
        dummy.next = head;
        int i = 1;
        Node prevLeft = dummy;
        Node currentLeft = head;

        while (i < left) {
            prevLeft = prevLeft.next;
            currentLeft = currentLeft.next;
            i++;
        }

        Node prev = currentLeft;
        Node current = currentLeft.next;
        while (i < right) {
            Node next = current.next;

            current.next = prev;
            prev = current;
            current = next;
            i++;
        }

        prevLeft.next = prev;
        currentLeft.next = current;
        return dummy.next;
    }

    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, new Node(6))))));
        int left = 1;
        int right = 4;

        Node newHead = reverseBetween(left, right, head);

        Node temp = newHead;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }
}
