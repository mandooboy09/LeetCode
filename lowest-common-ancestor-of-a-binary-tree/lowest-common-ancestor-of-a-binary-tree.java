/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode lca = null;
    public boolean search(TreeNode node, TreeNode p , TreeNode q){
        
        if(node == null){
            return false;
        }
        
        boolean flag = false;
        
        boolean left = search(node.left, p, q);
        boolean right = search(node.right, p, q);
        
        if(left || right || node == p || node == q){
            flag = true;
        }
        
        if(left && right){
            lca = node;
        }
        else if((left|| right) && (node == p || node == q)){
            lca = node;
        }
        
        return flag;
        
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        search(root, p, q);
        
        return lca;
    }
}