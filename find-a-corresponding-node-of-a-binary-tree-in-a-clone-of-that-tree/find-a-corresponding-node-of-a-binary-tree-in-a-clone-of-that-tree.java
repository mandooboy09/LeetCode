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
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.add(cloned);
        
        TreeNode clonedTarget = null;
        
        while(!bfsQueue.isEmpty()){
            TreeNode node = bfsQueue.poll();

            if(node.val == target.val){
                clonedTarget = node;
                break;
            }
            
            if(node.left != null){
                bfsQueue.add(node.left);
            }
            
            if(node.right != null){
                bfsQueue.add(node.right);
            }
        }
        return clonedTarget;
    }
}