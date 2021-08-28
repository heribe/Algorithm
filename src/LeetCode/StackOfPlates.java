package LeetCode;

import java.util.ArrayList;
import java.util.Stack;

class StackOfPlates {
    int cap;
    ArrayList<Stack<Integer>> list = new ArrayList<>();
    public StackOfPlates(int cap) {
        this.cap = cap;
    }

    public void push(int val) {
        if(cap==0) return;
        if(list.size()==0||list.get(list.size()-1).size()==cap){
            list.add(new Stack<>());
        }
        list.get(list.size()-1).push(val);
    }

    public int pop() {
        if(list.size()==0||cap==0) return -1;
        int res = list.get(list.size()-1).pop();
        if(list.get(list.size()-1).size()==0){
            list.remove(list.size()-1);
        }
        return res;
    }

    public int popAt(int index) {
        if(index<0||index>= list.size()||cap==0){
            return -1;
        }
        int res = list.get(index).pop();
        if(list.get(index).size()==0){
            list.remove(index);
        }
        return res;
    }
}