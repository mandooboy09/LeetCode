class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        ArrayList<Point2D> array = new ArrayList<>();
        
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(matrix[r][c] == 0){
                    array.add(new Point2D(r,c));
                }
            }
        }
        
        for(Point2D point : array){
            for(int r = 0; r < m; r++){
                matrix[r][point.c] = 0;
            }
            
            for(int c = 0; c < n; c++){
                matrix[point.r][c] = 0;
            }            
        }
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