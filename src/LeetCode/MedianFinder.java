package LeetCode;

import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Integer> small = new PriorityQueue<>((a, b)->b-a);
    PriorityQueue<Integer> big = new PriorityQueue<>();
    boolean isOdd = false;
    /** initialize your data structure here. */
    public MedianFinder() {

    }

    public void addNum(int num) {
        if(!isOdd) {
            if(small.size()==0) small.offer(num);
            else if(num<=big.peek()){
                small.offer(num);
            }else{
                int tmp = big.poll();
                big.offer(num);
                small.offer(tmp);
            }
        }else{
            if(num<small.peek()){
                int tmp = small.poll();
                small.offer(num);
                big.offer(tmp);
            }else{
                big.offer(num);
            }
        }
        isOdd = !isOdd;
    }

    public double findMedian() {
        if(!isOdd){
            return ((double)small.peek()+big.peek())/2;
        }else{
            return small.peek();
        }
    }
}