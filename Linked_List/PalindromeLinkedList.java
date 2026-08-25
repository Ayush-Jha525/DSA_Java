//Question : Given the head of a singly linked list, determine whether it is a palindrome.
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

public class PalindromeLinkedList {
    public static Node reverseList(Node head) {
        if (head == null) {
            return null;
        }
        Node prev = head;
        Node current = head.next;
        while (current != null) {
            Node next = current.next;

            current.next = prev;
            prev = current;
            current = next;
        }
        head.next = null;
        return prev;
    }

    public static Node findMid(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node mid = findMid(head);
        Node firstHead = head;
        Node secondHead = reverseList(mid.next);

        while (secondHead != null) {
            if (firstHead.value != secondHead.value) {
                return false;
            }
            firstHead = firstHead.next;
            secondHead = secondHead.next;
        }
        return true;
    }

    public static void main(String[] args) {
        // Linked list : 1->2->3->2->1
        Node head = new Node(1, new Node(2, new Node(3, new Node(2, new Node(1)))));

        System.out.println(isPalindrome(head));
    }
}
