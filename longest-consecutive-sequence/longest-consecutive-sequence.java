class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        Arrays.sort(nums);
        
        int answer = 1;
        int sequenceLength = 1;
        int prevNum = nums[0];

        for(int i = 1; i < nums.length; i++){
            int num = nums[i];
            if(prevNum == num){
                sequenceLength = sequenceLength;
            }
            else if(prevNum + 1 == num){
                sequenceLength += 1;
            }
            else{
                sequenceLength = 1;
            }
            answer = Math.max(answer, sequenceLength);
            prevNum = num;
        }
        
        return answer;
    }
}