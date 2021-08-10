class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] maxByRow = new int[n]; // r 별 최대 높이
        int[] maxByCol = new int[n]; // c 별 최대 높이
        
        // 각 r , c 별 최대 높이 구하기
        for(int r = 0; r < n; r++){
            for(int c = 0; c < n; c++){
                int height = grid[r][c]; // r c 위치 건물의 높이
                if(maxByRow[r] < grid[r][c]){
                    maxByRow[r] = grid[r][c];
                }

                if(maxByCol[c] < grid[r][c]){
                    maxByCol[c] = grid[r][c];
                }
            }
        }
        
        int answer = 0;
        // 건물 높이는 비용 구하기
        for(int r = 0; r < n; r++){
            for(int c = 0; c < n; c++){
                int possibleHeight = Math.min(maxByRow[r], maxByCol[c]);
                answer += possibleHeight - grid[r][c];
            }
        }
        
        return answer;
    }
}