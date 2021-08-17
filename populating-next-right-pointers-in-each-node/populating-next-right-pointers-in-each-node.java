/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        
        Queue<Node> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);
        
        while(!bfsQueue.isEmpty()){
            int n = bfsQueue.size();
            for(int i = 1; i <= n; i++){
                Node node = bfsQueue.poll();
                
                if(node.left != null){
                    bfsQueue.add(node.left);    
                }
                if(node.right != null){
                    bfsQueue.add(node.right);
                }                
                if(i != n){
                    node.next = bfsQueue.peek();
                }
            }
        }
            
        return root;
    }
}