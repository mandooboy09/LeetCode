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
        //base case
        if(target.val == cloned.val){
            return cloned;
        }
        
        TreeNode clonedTarget = null;
        if(cloned.left != null){
            clonedTarget = getTargetCopy(original, cloned.left, target);
        }
        
        if(clonedTarget != null){
            return clonedTarget;
        }

        if(cloned.right != null){
            clonedTarget = getTargetCopy(original, cloned.right, target);
        }        
        
        return getTargetCopy(original, cloned.right, target);
    }
}
