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
    public int getMaxIndex(int[] nums, int begin, int end){
        int index = begin;
        
        for(int i = begin; i <= end; i++){
            if(nums[index] < nums[i]){
                index = i;
            }
        }
        return index;
    }
    public TreeNode construct(int[] nums, int begin, int end){
        if(begin > end){
            return null;
        }
        
        int index = getMaxIndex(nums, begin, end);
        int val = nums[index];
                
        TreeNode node = new TreeNode(val);
        node.left = construct(nums, begin, index - 1);
        node.right = construct(nums, index + 1, end);

        return node;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n = nums.length;
        int index = getMaxIndex(nums, 0, n - 1);
        int val = nums[index];
        
        TreeNode root = new TreeNode(val);
        root.left = construct(nums, 0, index - 1);
        root.right = construct(nums, index + 1, n - 1);
        
        return root;
    }
}
