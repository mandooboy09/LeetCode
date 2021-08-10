class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        
        int n = queries.length;
        int m = points.length;
        
        int[] answer = new int[n];
        
        for(int i = 0; i < n; i++){
            int x = queries[i][0]; // x좌표
            int y = queries[i][1]; // y좌표
            int r = queries[i][2]; // 반지름 r

            //원의 중심 좌표에서 타겟 좌표까지의 길이가 반지름의 이하이면 원 내부의 좌표임
            for(int j = 0; j < m; j++){
                int pointX = points[j][0]; // 타겟 x좌표
                int pointY = points[j][1]; // 타겟 y좌표
                
                int sqrtDistance = (x - pointX) * (x - pointX) + (y - pointY) * (y - pointY);
                
                if(r * r >= sqrtDistance){
                    answer[i] += 1;
                }
            }
        }
        
        return answer;
    }
}