class Solution {
    
    public boolean increasingTriplet(int[] nums) {
        boolean answer = false;
        int n = nums.length;
        int small = Integer.MAX_VALUE;
        int big = Integer.MAX_VALUE;
        
        for(int num : nums){
            if(num <= small){
                small = num;
            }
            else if(num <= big){
                big = num;
            }
            else{
                answer = true;
                break;
            }
        }
        return answer;
    }
}