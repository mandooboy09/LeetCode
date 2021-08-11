class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int answer = 0;
        int[] arr = new int[points.length];

        for(int i = 0; i < points.length; i++){
            arr[i] = points[i][0];
        }
        
        Arrays.sort(arr);
        
        for(int i = 1; i < arr.length; i++){
            int leftX = arr[i-1];
            int rightX = arr[i];
            if(answer < rightX - leftX){
                answer = rightX - leftX;
            }
        }
        
        return answer;
        
    }
}
