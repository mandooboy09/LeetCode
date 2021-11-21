class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        
        for(int i = 0; i < nums.length; i += 1){
            int num = target - nums[i];
            boolean pass = false;
            for(int j = 0; j < nums.length; j += 1){
                if(i == j){
                    continue;
                }
                
                if(num == nums[j]){
                    answer[0] = i;
                    answer[1] = j;
                    pass = true;
                    break;
                }
            }
            
            if(pass == true){
                break;
            }
        }
        
        return answer;
        
    }
}