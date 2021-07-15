package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Inorder {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args){

        TreeNode root= new TreeNode(3);
        root.left= new TreeNode(9);
        root.right= new TreeNode(20);
        root.right.left= new TreeNode(15);
        root.right.right= new TreeNode(7);

        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if(root == null){
            return ;
        }

        while(root!=null || !stack.isEmpty()){

            while(root != null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            list.add(root.val);

            root = root.right;
        }


        System.out.println(list);
    }



}

