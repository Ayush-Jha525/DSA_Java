/*Question : Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty). */
// Time Complexity :
// push : O(n)
// pop : O(1)
// peek : O(1)
// empty : O(1)
// Space Complexity : O(n)
package Queue;

import java.util.Stack;

class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(x);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    public int pop() {
        if (s1.isEmpty()) {
            return -1;
        }
        return s1.pop();
    }

    public int peek() {
        if (s1.isEmpty()) {
            return -1;
        }
        return s1.peek();
    }

    public boolean empty() {
        return s1.isEmpty();
    }
}

public class ImplementQueueUsingStacks {
    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.push(1); // queue is: [1]
        q.push(2); // queue is: [1, 2]
        System.out.println(q.peek()); // return 1
        System.out.println(q.pop()); // return 1, queue is [2]
        System.out.println(q.empty()); // return false
    }
}
