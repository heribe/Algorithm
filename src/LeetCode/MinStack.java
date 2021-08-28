package LeetCode;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

class MinStack {
    Stack<Integer> stack;
    PriorityQueue<Integer> pq;
    HashMap<Integer,Integer> map;


    /** initialize your data structure here. */
    public MinStack() {
        stack=new Stack<>();
        pq = new PriorityQueue<>();
        map = new HashMap<>();
    }

    public void push(int x) {
        stack.push(x);
        pq.offer(x);
        map.put(x,map.getOrDefault(x,0)+1);
    }

    public void pop() {
        int p = stack.pop();
        map.put(p,map.get(p)-1);
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        while(map.get(pq.peek())==0){
            pq.poll();
        }
        return pq.peek();
    }
}
