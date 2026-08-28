/*Question : Given a node node in a singly linked list, delete that node.
    You are not given the head of the list.
    You can assume:
        * The node to delete is not the tail.
        * All node values are unique.*/
//Time Complexity:  O(1)
//Space Complexity: O(1)
package Linked_List;

public class DeleteNodeWithoutLinkedListHead {
    public static void deleteNode(Node node) {
        node.value = node.next.value;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        Node head = new Node(1, new Node(3, new Node(5, new Node(7, new Node(8)))));

        Node node = head.next.next;
        deleteNode(node);

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }
}
