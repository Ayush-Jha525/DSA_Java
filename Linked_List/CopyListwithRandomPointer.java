/*Question : Given the head of a linked list where each node contains:
                * val
                * next
                * random

The next pointer points to the next node, while random can point to any node in the list or null.
Create a deep copy of the entire linked list and return the head of the copied list. */
//Time Complexity: O(n)
//Space Complexity: O(1)
package Linked_List;

class RandomNode {
    int val;
    RandomNode next;
    RandomNode random;

    public RandomNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListwithRandomPointer {
    public static RandomNode copyRandomList(RandomNode head) {
        if (head == null) {
            return null;
        }

        RandomNode current = head;
        while (current != null) {
            RandomNode nextRandomNode = current.next;

            current.next = new RandomNode(current.val);
            current.next.next = nextRandomNode;

            current = nextRandomNode;
        }

        current = head;
        while (current != null) {
            RandomNode currentRandom = current.random;

            if (currentRandom == null) {
                current.next.random = null;
            } else {
                current.next.random = currentRandom.next;
            }

            current = current.next.next;
        }

        RandomNode newHead = new RandomNode(0);
        RandomNode copy = newHead;
        current = head;
        while (current != null) {
            copy.next = current.next;

            current.next = current.next.next;

            copy = copy.next;
            current = current.next;
        }
        copy.next = null;

        return newHead.next;
    }

    public static void printList(RandomNode head) {
        RandomNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + "(");
            if (temp.random != null) {
                System.out.print(temp.random.val);
            } else {
                System.out.print("null");
            }
            System.out.print(")");

            if (temp.next != null) {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Creating a linked list with random pointer
        RandomNode head = new RandomNode(1);
        head.next = new RandomNode(2);
        head.next.next = new RandomNode(3);
        head.next.next.next = new RandomNode(4);
        head.next.next.next.next = new RandomNode(5);
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head.next;

        // Print the original list
        System.out.println("Original linked list:");
        printList(head);

        RandomNode clonedList = copyRandomList(head);

        System.out.println("Cloned linked list:");
        printList(clonedList);
    }
}
