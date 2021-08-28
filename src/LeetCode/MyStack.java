package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> a;
    Queue<Integer> b;
    /** Initialize your data structure here. */
    public MyStack() {
        a = new LinkedList<>();
        b = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        b.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while(b.size()>1){
            a.offer(b.poll());
        }
        Queue<Integer> c = a;a = b;b = c;
        return a.poll();
    }

    /** Get the top element. */
    public int top() {
        while(b.size()>1){
            a.offer(b.poll());
        }
        Queue<Integer> c = a;a = b;b = c;
        int ans = a.peek();
        b.offer(a.poll());
        return ans;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return b.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */