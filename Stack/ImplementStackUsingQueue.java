//Question : Implement a Last-In-First-Out (LIFO) stack using only the standard operations of a queue.
//Implement the following methods:
//  * push(int x) – Push element x onto the stack.
//  * pop() – Remove and return the element on the top of the stack.
//  * top() – Return the top element.
//  * empty() – Return true if the stack is empty, otherwise false.

//Time complexity : Operation	Complexity
//                      push()	    O(n)
//                      pop()	    O(1)
//                      top()	    O(1)
//                      empty()	    O(1)

package Stack;

import java.util.Queue;
import java.util.LinkedList;

class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        q1.add(x);
        while (!q2.isEmpty()) {
            q1.add(q2.remove());
        }
    }

    public int pop() {
        if (q1.isEmpty()) {
            return -1;
        }
        return q1.remove();
    }

    public int top() {
        if (q1.isEmpty()) {
            return -1;
        }
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}

public class ImplementStackUsingQueue {
    public static void main(String[] args) {
        MyStack obj = new MyStack();
        System.out.println(obj.empty());
        obj.push(3);
        obj.push(5);
        obj.push(2);
        obj.push(7);
        System.out.println(obj.pop());
        System.out.println(obj.top());
        System.out.println(obj.empty());
    }
}
