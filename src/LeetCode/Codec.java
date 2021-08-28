package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "[]";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        sb.append(root.val);
        sb.append(',');
        queue.add(root);
        int ceng = 0;
        while(!queue.isEmpty()){
            int n = queue.size();
            ceng++;
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
        }
        int newceng=0;
        queue.add(root);
        while (!queue.isEmpty()){
            int n = queue.size();
            newceng++;
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if(node.left==null) {
                    if(newceng!=ceng) sb.append("null,");
                } else{
                    sb.append(node.left.val);
                    sb.append(',');
                    queue.add(node.left);
                }
                if(node.right==null) {
                    if(newceng!=ceng) sb.append("null,");
                } else{
                    sb.append(node.right.val);
                    sb.append(',');
                    queue.add(node.right);
                }
            }

        }
        sb.deleteCharAt(sb.length()-1);
        sb.append(']');
//        System.out.println(sb.toString());//
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==2) return null;
        String[] str = data.substring(1,data.length()-1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i=1;
        while (i < str.length) {
            TreeNode node = queue.poll();
            if(!str[i].equals("null")){
                node.left = new TreeNode(Integer.parseInt(str[i]));
                queue.offer(node.left);
            }
            i++;
            if(!str[i].equals("null")){
                node.right = new TreeNode(Integer.parseInt(str[i]));
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }
}
