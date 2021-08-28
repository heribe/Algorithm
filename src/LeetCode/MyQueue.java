package LeetCode;

import java.util.Stack;

class MyQueue {
    Stack<Integer> a;
    Stack<Integer> b;
    /** Initialize your data structure here. */
    public MyQueue() {
        a = new Stack<>();
        b = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        b.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(a.empty()){
            while(!b.empty()) a.push(b.pop());
        }
        return a.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(a.empty()){
            while(!b.empty()) a.push(b.pop());
        }
        return a.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return a.empty()&&b.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */