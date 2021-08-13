class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answers = new int[n];
        
        //left -> right multify
        answers[0] = 1;
        int val = nums[0];
        for(int i = 1; i < n; i++){
            answers[i] = val;
            val *= nums[i];
        }
        
        // right -> left multify
        val = nums[n - 1];
        for(int i = n - 2; i >= 0; i--){
            answers[i] *= val;
            val *= nums[i];
        }
        
        return answers;
    }
}