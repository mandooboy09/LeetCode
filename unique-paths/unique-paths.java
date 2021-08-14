class Solution {
    public final int[] deltaR = {0,-1};
    public final int[] deltaC = {-1,0};
    
    public boolean isInside(int r, int c){
        if( r < 0){
            return false;
        }
        if( c < 0){
            return false;
        }
        
        return true;
    }
    
    public int uniquePaths(int m, int n) {
        int[][] visited = new int[m][n];
        visited[0][0] = 1;
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                //현재 위치의 왼쪽과 위쪽의 값을 더한다
                for(int i = 0; i < deltaR.length; i++){
                    int prevR = r + deltaR[i];
                    int prevC = c + deltaC[i];
                    
                    if(!isInside(prevR, prevC))
                        continue;
                    visited[r][c] += visited[prevR][prevC];
                }
            }
        }
        return visited[m-1][n-1];
    }
}