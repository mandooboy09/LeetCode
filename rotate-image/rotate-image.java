class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] copy = new int[n][n];
        
        for(int r = 0; r < n; r++){
            for(int c = 0; c < n; c++){
                copy[r][c] = matrix[r][c];
            }
        }

        int row = 0;
        int col = n - 1;
        while(row < n && col >= 0){
            int[] rowArr = copy[row];
            int r = 0;
            for(int num : rowArr){
                // System.out.println(num);
                matrix[r][col] = num;
                r += 1;
            }
            row += 1;
            col -= 1;
        }
    }
}