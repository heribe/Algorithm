package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class ACautomaton {
    // node类
    class Node{
        int flag;  //记录是单词的次数 -1表示已经被访问过
        int child[];
        int fail;
        public Node() {
            flag=0;
            fail=0;
            child=new int[childn];
        }
    }

    // 初始化
    Node[] nodes;
    int size;
    int childn;
    int minchar;
    public ACautomaton(int maxsize) {
        childn=26;
        minchar='a';
        nodes = new Node[maxsize];
        size=0;
        nodes[0]=new Node(); // 0结点
        nodes[1]=new Node(); // root结点
        for (int i = 0; i < childn; i++) {
            nodes[0].child[i]=1; // 0结点的所有儿子都指向root结点
        }
    }

    public void insert(String s){
        int u = 1;
        for (int i = 0; i < s.length(); i++) {
            int v = s.charAt(i) - minchar;
            if(nodes[u].child[v]==0){
                nodes[u].child[v]=++size;
                nodes[size]=new Node();
            }
            u=nodes[u].child[v];
        }
        nodes[u].flag++;
    }

    public void initFail(){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        while (!queue.isEmpty()){
            int u = queue.poll();
            for (int i = 0; i < childn; i++) {
                int v = nodes[u].child[i];
                if(v==0){
                    nodes[u].child[i]=nodes[nodes[u].fail].child[i];
                }else{
                    nodes[v].fail=nodes[nodes[u].fail].child[i];
                    queue.offer(v);
                }
            }
        }
    }

    public int query(String s){
        int u = 1;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int v = s.charAt(i)-minchar;
            u = nodes[u].child[v];
            int k = u;
            while (k>1&&nodes[k].flag!=-1){
                ans+=nodes[k].flag;
                nodes[k].flag=-1;
                k=nodes[k].fail;
            }
        }
        return ans;
    }
}
