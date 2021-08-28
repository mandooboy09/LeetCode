class Solution {
    final int[] deltaR = {0,-1,0,1};  //←↑→↓
    final int[] deltaC = {-1,0,1,0};  //←↑→↓
    
    public boolean isInside(int r, int c, int m, int n){
        if(r < 0 || r >= m){
            return false;
        }
        
        if(c < 0 || c >= n){
            return false;
        }
        return true;
    }
    
    public int search(int[][] matrix, int r, int c, int m, int n, int[][] cache){
        if(cache[r][c] != 0){
            return cache[r][c];
        }
        
        int max = 1;
        for(int i = 0; i < deltaR.length; i++){
            int nextR = r + deltaR[i];
            int nextC = c + deltaC[i];
            
            if(!isInside(nextR,nextC,m,n) || matrix[nextR][nextC] <= matrix[r][c]){
                continue;
            }
            
            int longestPathCount = 1 + search(matrix, nextR, nextC, m, n, cache);
            max = Math.max(max, longestPathCount);
        }
        
        cache[r][c] = max;
        
        return max;
        
    }
    
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] cache = new int[m][n];
        
        int answer = 0;
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                int longestPathCount = search(matrix, r, c, m, n, cache);
                answer = Math.max(answer, longestPathCount);
            }
        }
        return answer;
    }
}

class Point2D{
    int r;
    int c;
    
    public Point2D(int r, int c){
        this.r = r;
        this.c = c;
    }
}