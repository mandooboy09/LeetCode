class Solution {
    public int[] deltaR = {0,-1,-1,-1,0,1,1,1}; //←↖↑↗→↘↓↙
    public int[] deltaC = {-1,-1,0,1,1,1,0,-1}; //←↖↑↗→↘↓↙
    public final int LIVE = 1;
    public final int DEAD = 0;
    
    public boolean isInside(int row, int col, int m, int n){
        if(row < 0 || row >= m){
            return false;
        }
        
        if(col < 0 || col >= n){
            return false;
        }
            
        return true;
    }
        
    public int getAdjcentLiveNeighbors(int[][] board, int row, int col, int m, int n){
        int count = 0;
        
        for(int i = 0; i < deltaR.length; i++){
            int nextR = row + deltaR[i];
            int nextC = col + deltaC[i];
            
            if(isInside(nextR, nextC, m, n)){
                count += board[nextR][nextC];
            }
        }
        
        return count;
    }
    
    public int getNextStatus(int status, int neighbors){
        int result = status;
        
        if(neighbors < 2){
            result = DEAD;
        }
        else if(status == LIVE && 2 <= neighbors && neighbors <= 3){
            result = LIVE;
        }
        else if(neighbors > 3){
            result = DEAD;
        }
        else if(status == DEAD && neighbors == 3){
            result = LIVE;
        }
        
        return result;
    }
    
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] nextBoard = new int[m][n];
        
        // cell 별 다음 상태 
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                //인접한 살아 있는 이웃 탐색
                int status = board[r][c]; // 상태
                int neighbors = getAdjcentLiveNeighbors(board, r, c, m, n);
                System.out.printf("%d %d %d\n",r,c, neighbors);
                //조건에 따라 다음 턴의 생사여부 결정
                nextBoard[r][c] = getNextStatus(status, neighbors);
            }
        }
         
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                board[r][c] = nextBoard[r][c];
            }
        }
    }
}