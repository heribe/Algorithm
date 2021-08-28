package LeetCode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class MaxQueue {
    Deque<Integer> deque = new LinkedList<>();
    Queue<Integer> queue = new LinkedList<>();
    public MaxQueue() {

    }

    public int max_value() {
        if(deque.isEmpty()) return -1;
        return deque.peekFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        while(!deque.isEmpty()&&deque.peekLast()<value) deque.pollLast();
        deque.offerLast(value);
    }

    public int pop_front() {
        if(queue.isEmpty()) return -1;
        if(deque.peekFirst().equals(queue.peek())) deque.pollFirst();
        return queue.poll();
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
