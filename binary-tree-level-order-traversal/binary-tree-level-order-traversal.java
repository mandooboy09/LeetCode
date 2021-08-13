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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answers = new ArrayList<>();
        Queue<TreeNode> bfsQueue = new LinkedList<>();

        if(root != null){
            bfsQueue.add(root);
        }
        // bfs 탐색
        while(!bfsQueue.isEmpty()){
            int n = bfsQueue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0; i < n; i++){
                TreeNode node = bfsQueue.poll();
                list.add(node.val);
                
                if(node.left != null){
                    bfsQueue.add(node.left);
                }
                if(node.right != null){
                    bfsQueue.add(node.right);
                }
            }
            answers.add(list);            
        }
        return answers;
    }
}