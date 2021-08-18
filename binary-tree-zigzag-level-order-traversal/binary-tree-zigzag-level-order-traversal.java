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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        if(root != null){
            bfsQueue.add(root);
        }
        int level = 0;
        
        while(!bfsQueue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            int n = bfsQueue.size();
            
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
            if(level % 2 == 1){
                Stack<Integer> stack = new Stack<>();
                while(!list.isEmpty()){
                    stack.push(list.remove(0));
                }
                while(!stack.isEmpty()){
                    list.add(stack.pop());
                }
            }
            answer.add(list);
            level += 1;
        }
        
        return answer;
    }
}