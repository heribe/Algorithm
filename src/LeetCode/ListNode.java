package LeetCode;


public class ListNode {
    int val;
    ListNode next;
    ListNode(){};
    ListNode(int x) { val = x; }
    ListNode(int x,ListNode node){
        val = x;
        next = node;
    }
}