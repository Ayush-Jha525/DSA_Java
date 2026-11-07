/*Question : Implement the MyCircularQueue class:
    * MyCircularQueue(k) : Initializes the object with the size of the queue to be k.
    * int Front() : Gets the front item from the queue. If the queue is empty, return -1.
    * int Rear() : Gets the last item from the queue. If the queue is empty, return -1.
    * boolean enQueue(int value) : Inserts an element into the circular queue. Return true if the operation is successful.
    * boolean deQueue() : Deletes an element from the circular queue. Return true if the operation is successful.
    * boolean isEmpty() : Checks whether the circular queue is empty or not.
    * boolean isFull() : Checks whether the circular queue is full or not.
You must solve the problem without using the built-in queue data structure in your programming language. */

package Arrays;

class MyCircularQueue {
    int front, rear;
    int[] queue;

    public MyCircularQueue(int k) {
        queue = new int[k];
        front = rear = -1;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            front = rear = 0;
            queue[rear] = value;
            return true;
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % queue.length;
        }
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return queue[front];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return queue[rear];
    }

    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    public boolean isFull() {
        return (rear + 1) % queue.length == front;
    }
}

public class DesignCircularQueue {
    public static void main(String[] args) {
        MyCircularQueue obj = new MyCircularQueue(3);
        System.out.println(obj.enQueue(1));
        System.out.println(obj.enQueue(2));
        System.out.println(obj.enQueue(3));
        System.out.println(obj.enQueue(4));

        System.out.println(obj.Rear());

        System.out.println(obj.isFull());

        System.out.println(obj.Front());

        System.out.println(obj.deQueue());

        System.out.println(obj.enQueue(4));

        System.out.println(obj.Rear());

        System.out.println(obj.Front());

    }
}
