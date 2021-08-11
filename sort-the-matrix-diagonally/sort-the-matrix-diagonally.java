class Solution {
    public boolean isInside(int r, int c, int m, int n){
        if(r < 0 || r >= m){
            return false;
        }
        
        if(c < 0 || c >= n){
            return false;
        }

        return true;
    }
    public int[][] diagonalSort(int[][] mat) {
        ArrayList<int[]> begins = new ArrayList<>();
        begins.add(new int[]{0,0});
        int m = mat.length;
        int n = mat[0].length;
        int[][] answer = new int[m][n];
        //대각선 시작 위치 모으기
        // 대각선 시작 위치 row = 0 or col = 0
        for(int r = 1; r < m; r++){
            begins.add(new int[]{r,0});
        }
        for(int c = 1; c < n; c++){
            begins.add(new int[]{0,c});
        }
        
        for(int[] begin: begins){
            int r = begin[0];
            int c = begin[1];
            ArrayList<Integer> diagonal = new ArrayList<>();

            while(isInside(r, c, m, n)){
                diagonal.add(mat[r][c]);
                r += 1;
                c += 1;
            }
            // 대각선 정렬
            Collections.sort(diagonal);
            r = begin[0];
            c = begin[1];
            
            for(Integer num : diagonal){
                answer[r][c] = num;
                r += 1;
                c += 1;
            }
        }
        
        return answer;
    }
}