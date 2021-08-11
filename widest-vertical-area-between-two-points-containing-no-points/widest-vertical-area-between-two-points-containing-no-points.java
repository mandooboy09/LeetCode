class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int answer = 0;
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i = 0; i < points.length; i++){
            arr.add(points[i][0]); // x좌표 넣어줌
        }
        Collections.sort(arr);
        
        for(int i = 1; i < arr.size(); i++){
            int leftX = arr.get(i - 1);
            int rightX = arr.get(i);
            answer = Math.max(answer, rightX - leftX);
        }
        
        return answer;
    }
}