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
    public TreeNode constructMaximumBinaryTreeHelper(int[] nums, int begin, int end){
        if(begin > end){
            return null;
        }

        int maxVal = nums[begin];
        int maxIndex = begin;
        
        for(int i = begin; i <= end; i++){
            if(maxVal < nums[i]){
                maxVal = nums[i];
                maxIndex = i;
            }
        }
        
        TreeNode node = new TreeNode(maxVal);
        node.left = constructMaximumBinaryTreeHelper(nums, begin, maxIndex - 1);
        node.right = constructMaximumBinaryTreeHelper(nums, maxIndex + 1, end);        

        return node;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n = nums.length;
        int maxVal = nums[0];
        int maxIndex = 0;
        for(int i = 1; i < n; i++){
            if(maxVal < nums[i]){
                maxVal = nums[i];
                maxIndex = i;
            }
        }
        
        TreeNode root = new TreeNode(maxVal);
        root.left = constructMaximumBinaryTreeHelper(nums, 0, maxIndex - 1);
        root.right = constructMaximumBinaryTreeHelper(nums, maxIndex + 1, n - 1);
        
        return root;
    }
}