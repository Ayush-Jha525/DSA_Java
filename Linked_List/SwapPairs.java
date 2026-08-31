/*Question: Given the head of a linked list, swap every two adjacent nodes and return the modified list.*/
//Time Complexity: O(n)
//Space Complexity: O(1)
package Linked_List;

public class SwapPairs {
    public static Node swapPairs(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node newHead = new Node(0);
        Node temp = newHead;
        Node first = head;
        Node second = head.next;

        while (first != null && second != null) {
            Node next = second.next;

            temp.next = second;
            second.next = first;
            first.next = next;
            temp = first;

            first = first.next;
            if (first != null) {
                second = first.next;
            }
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, new Node(6))))));

        Node newHead = swapPairs(head);
        Node temp = newHead;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }
}