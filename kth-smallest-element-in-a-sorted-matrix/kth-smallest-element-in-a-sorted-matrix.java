class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int size = n * n - k + 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                pq.add(matrix[i][j]);
                if(pq.size() > size){
                    pq.poll();
                }
            }
        }
        answer = pq.peek();
        
        return answer;
    }
}