class Solution {
    char WATER = '0';
    int[] deltaR = {0,-1,0,1}; //←↑→↓
    int[] deltaC = {-1,0,1,0}; //←↑→↓
    
    public boolean isInside(int r, int c, int m, int n){
        if(r < 0 || r >= m){
            return false;
        }
        
        if(c < 0 || c >= n){
            return false;
        }
        
        return true;
    }
    
    public void search(boolean[][] visited, int r, int c, int m, int n, char[][] grid){
        if(!isInside(r,c,m,n)){
            return ;
        }
        
        if(visited[r][c]){
            return ;
        }
        
        visited[r][c] = true;
        
        if(grid[r][c] == WATER){
            return ;
        }
        
        for(int i = 0; i < deltaR.length; i++){
            int nextR = r + deltaR[i];
            int nextC = c + deltaC[i];
            search(visited, nextR, nextC, m, n, grid);
        }
        
        return;
    }
    
    public int numIslands(char[][] grid) {
        int answer = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(grid[r][c] == WATER || visited[r][c]){
                    continue;
                }
                search(visited, r, c, m, n, grid);
                answer += 1;
            }
        }
        
        
        return answer;
    }
}