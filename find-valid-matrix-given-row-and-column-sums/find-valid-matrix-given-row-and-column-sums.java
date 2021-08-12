class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        // 1. r , c 탐색 O(N^2)
        // 2. 각 좌표별 rowSum colSum 의 최소값을 배정 하고 최소값만큼 rowSum colSum에서 차감
        int n = rowSum.length;
        int m = colSum.length;
        int[][] answer = new int[n][m];
        
        for(int r = 0; r < n; r++){
            for(int c = 0; c < m; c++){
                int value = Math.min(rowSum[r], colSum[c]);
                answer[r][c] = value;
                rowSum[r] -= value;
                colSum[c] -= value;
            }
        }
        return answer;
    }
}