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
    public int bstToGst(TreeNode root, int s) {
        //base case
        if(root == null){
            return 0; 
        }
        
        int sum = root.val + bstToGst(root.right, s);
        root.val = sum + s;
        sum += bstToGst(root.left, root.val);
        
        return sum;
    
    }
    public TreeNode bstToGst(TreeNode root) {
            bstToGst(root, 0);
        return root;
    }
}