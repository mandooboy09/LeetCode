class Solution {
    public int fill(int[] nums, int[] memo, int index){
        if(index < 0){
            return 0;
        }
        
        if(memo[index] != 0){
            return memo[index];
        }
        
        int max = 1;
        for(int i = index - 1; i >= 0; i--){
            if(nums[index] <= nums[i]){
                continue;
            }
            
            int val = 1 + fill(nums, memo, i);
            max = Math.max(max, val);
        }
        
        memo[index] = max;
        
        return max;
        
    }
    public int lengthOfLIS(int[] nums) {
        int[] memo = new int[nums.length];
        int answer = 0;
        
        for(int i = 0; i < nums.length; i++){
            int val = fill(nums, memo, i);
            answer = Math.max(answer, val);
        }
        System.out.println(Arrays.toString(memo));
        return answer;
    }
}