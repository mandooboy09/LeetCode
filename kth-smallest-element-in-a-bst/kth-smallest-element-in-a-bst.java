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
    
    public int kthSmallest(TreeNode root, int k) {
        //1. 전체탐색
        //2. 정렬
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);
        while(!bfsQueue.isEmpty()){
            TreeNode node = bfsQueue.poll();
            list.add(node.val);
            
            if(node.left != null){
                bfsQueue.add(node.left);
            }
            
            if(node.right != null){
                bfsQueue.add(node.right);
            }
        }
        
        Collections.sort(list);
        int answer = list.get(k - 1);
        
        return answer;
        
    }
}