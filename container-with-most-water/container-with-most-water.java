class Solution {
    public int maxArea(int[] height) {
        int answer = 0;
        int left = 0;
        int right = height.length - 1;
        
        while(left < right){
            int h = Math.min(height[left], height[right]);
            int area = (right - left) * h;
            answer = Math.max(answer, area);
            
            if(height[left] < height[right]){
                left +=1;
            }
            else{
                right -= 1;
            }
        }
        return answer;
    }
}