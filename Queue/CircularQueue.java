//Question : Design a circular queue using an array.
// Time Complexity : O(1)
// Space Complexity : O(n)

package Queue;

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

public class CircularQueue {
    public static void main(String[] args) {
        MyCircularQueue obj = new MyCircularQueue(5);
        System.out.println(obj.isEmpty());
        obj.enQueue(2);
        obj.enQueue(3);
        System.out.println(obj.Front());
        System.out.println(obj.deQueue());
        obj.enQueue(4);
        System.out.println(obj.Rear());
        obj.enQueue(5);

        System.out.println(obj.isFull());

    }
}
