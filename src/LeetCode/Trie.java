package LeetCode;

// 未完全测试
public class Trie {
    // node类
    class Node{
        int[] child;
        boolean flag;     //flag用于标记是否是某个单词结尾
        int cnt;     //cnt用于标记被查询过的次数;
        public Node(){
            child=new int[26];
            flag=false;
            cnt=0;
        }
    }
    // 初始化
    private Node[] nodes;
    private int size;
    public Trie(int maxnode){
        nodes = new Node[maxnode];
        size=0;
    }

    /**
     * insert string
     * @param s
     * @return  true:no same string
     */
    public boolean insert(String s){
        int u = 0;
        for (int i = 0; i < s.length(); i++) {
            int v = s.charAt(i)-'a';
            if(nodes[u]==null) nodes[u]=new Node();
            if(nodes[u].child[v]==0) nodes[u].child[v]=(++size); //如果没有结点就加一个
            u=nodes[u].child[v];
        }
        if(nodes[u]==null) nodes[u]=new Node();
        if(nodes[u].flag) return false;
        nodes[u].flag=true;
        return true;
    }

    /**
     *
     * @param s
     * @return 0:no string  1:sucess  >1:string used
     */
    public int find(String s){
        int u=0;
        for (int i = 0; i < s.length(); i++) {
            int v=s.charAt(i)-'a';
            if((u=nodes[u].child[v])==0) return 0;
        }
        if(!nodes[u].flag) return 0;
        return ++nodes[u].cnt;
    }

}

