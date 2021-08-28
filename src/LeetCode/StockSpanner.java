package LeetCode;


import java.util.ArrayList;
import java.util.Stack;

class StockSpanner {
    ArrayList<Integer> list = new ArrayList<>();
    Stack<int[]> stack = new Stack<>();
    int n=0;
    public StockSpanner() {

    }

    public int next(int price) {
        n++;
        int res=1;
        if(n==1) {
            res =  1;
        }else{
            while(!stack.isEmpty()&&stack.peek()[0]<=price) stack.pop();
            if(stack.isEmpty()) res=n;
            else{
                res=n-stack.peek()[1];
            }
        }
        stack.push(new int[]{price,n});
        return res;
    }
}




//class StockSpanner {
//
//    class Ssnode{
//        int val;
//        int leftval=0;
//        int rightval=0;
//        int n=1;
//        Ssnode left;
//        Ssnode right;
//        public Ssnode(int val){
//            this.val=val;
//        }
//    }
//
//    Ssnode root = null;
//
//    public StockSpanner() {
//
//    }
//
//    public int next(int price) {
//        if(root ==null) {
//            root =new Ssnode(price);
//            return 1;
//        }
//        Ssnode pre = root;
//        Ssnode node = root;
//        int res=0;
//        boolean zuo=true;
//        while(node!=null){
//            pre=node;
//            if(node.val==price){
//                res+=node.leftval;
//                node.n++;
//                break;
//            }else if(node.val<price){
//                zuo=false;
//                res+=node.n-node.rightval;
//                node.n++;
//                node.rightval++;
////                pre = node;
//                node = node.right;
//            }else{
//                zuo=true;
////                pre = node;
//                node.leftval++;
//                node.n++;
//                node = node.left;
//            }
//        }
//        if(node==null){
//            if(zuo) {
//                pre.left=new Ssnode(price);
////                pre.n++;pre.leftval++;
//            }
//            else {
//                pre.right=new Ssnode(price);
////                pre.n++;pre.rightval++;
//            }
//        }
//        return res+1;
//    }
//}
