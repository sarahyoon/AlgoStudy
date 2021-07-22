/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> getLonelyNodes(TreeNode root) {

        List<Integer> list = new ArrayList<Integer>();
        check(root, list);

        return list;
    }

    public void check(TreeNode node, List<Integer> list){

        if(node.left == null && node.right == null) {
            return;
        }

        if(node.left != null && node.right != null){
            check(node.left, list);
            check(node.right, list);
        }
        else if(node.left != null){
            list.add(node.left.val);
            check(node.left, list);
        }
        else{
            list.add(node.right.val);
            check(node.right, list);
        }
    }
}