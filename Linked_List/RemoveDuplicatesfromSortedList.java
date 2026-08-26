//Question : Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
//Time Complexity:  O(n)
//Space Complexity: O(1)
package Linked_List;

public class RemoveDuplicatesfromSortedList {
    public static Node removeDuplicate(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node current = head;
        while (current.next != null) {
            if (current.value == current.next.value) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Node list = new Node(1, new Node(1, new Node(3, new Node(3, new Node(4)))));

        Node sorted = removeDuplicate(list);

        while (sorted != null) {
            System.out.print(sorted.value + " -> ");
            sorted = sorted.next;
        }
        System.out.println("Null");
    }
}
