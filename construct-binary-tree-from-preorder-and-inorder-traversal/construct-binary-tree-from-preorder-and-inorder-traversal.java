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
    int preIndex = 0;
    
    public TreeNode construct(HashMap<Integer, Integer> map, int[] preorder, int[] inorder, int begin, int end){
        //base case
        if(preIndex == preorder.length || begin > end){
            return null;
        }
        
        TreeNode node = new TreeNode(preorder[preIndex++]);
        int inIndex = map.get(node.val);
        
        node.left = construct(map, preorder, inorder, begin, inIndex - 1);
        node.right = construct(map, preorder, inorder, inIndex + 1, end);
        
        return node;
        
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        TreeNode root = construct(map, preorder, inorder, 0, inorder.length - 1);
        return root;
    }
}