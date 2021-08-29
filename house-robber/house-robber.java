class Solution {
    static final int EMPTY = -1;
    public int fill(int[] nums, int[] memo, int index){
        if(index < 0){
            return 0;
        }
        
        if(memo[index] != EMPTY){
            return memo[index];
        }
        
        int value1 = fill(nums, memo, index - 1);
        int value2 = fill(nums, memo, index - 2) + nums[index];
        
        int max = Math.max(value1, value2);
        
        memo[index] = max;
        return max;
    }
    
    public int rob(int[] nums) {
        int answer = 0;
        int n = nums.length;
        int[] memo = new int[n];
        Arrays.fill(memo, EMPTY);
        
        for(int i = 0; i < n; i++){
            answer = Math.max(answer, fill(nums, memo, i));
        }
        
        return answer;
    }
}