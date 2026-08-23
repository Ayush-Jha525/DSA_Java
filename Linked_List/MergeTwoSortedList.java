//Question : Given the heads of two sorted linked lists, merge them into one sorted linked list and return its head.
//Time Complexity:  O(n + m)
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

public class MergeTwoSortedList {
    public static Node mergeList(Node list1, Node list2) {
        Node head = new Node(0);
        Node sorted = head;

        while (list1 != null && list2 != null) {
            if (list1.value <= list2.value) {
                sorted.next = list1;
                list1 = list1.next;
            } else {
                sorted.next = list2;
                list2 = list2.next;
            }
            sorted = sorted.next;
        }

        while (list1 != null) {
            sorted.next = list1;
            list1 = list1.next;
            sorted = sorted.next;
        }

        while (list2 != null) {
            sorted.next = list2;
            list2 = list2.next;
            sorted = sorted.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        Node list1 = new Node(1, new Node(3, new Node(5, new Node(7))));
        Node list2 = new Node(2, new Node(4, new Node(6, new Node(8))));

        Node sorted = mergeList(list1, list2);

        while (sorted != null) {
            System.out.print(sorted.value + " -> ");
            sorted = sorted.next;
        }
        System.out.println("Null");
    }
}
