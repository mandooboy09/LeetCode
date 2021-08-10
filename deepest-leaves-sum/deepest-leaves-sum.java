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
    public int deepestLeavesSum(TreeNode root) {
        //탐색하여 Deepest LeavesSum
        int answer = 0;
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);
        
        //depth 별 탐색
        while(!bfsQueue.isEmpty()){
            answer = 0;
            for(int i = bfsQueue.size() - 1; i >= 0; i--){
                TreeNode leave = bfsQueue.poll();
                answer += leave.val;
                if(leave.left != null){
                    bfsQueue.add(leave.left);
                }
                
                if(leave.right != null){
                    bfsQueue.add(leave.right);
                }
            }
        }
            
        return answer;
        
    }
}