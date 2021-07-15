package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class Preorder {

    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    static List<Integer> list;

    public static void main(String[] args){

        TreeNode root= new TreeNode(3);
        root.left= new TreeNode(9);
        root.right= new TreeNode(20);
        root.right.left= new TreeNode(15);
        root.right.right= new TreeNode(7);

        list = new ArrayList<>();
        preorder(root);

        System.out.println(list);
    }


    public static void preorder(TreeNode node){

        if(node == null){
            return;
        }

        list.add(node.val);
        preorder(node.left);
        preorder(node.right);
    }
}
