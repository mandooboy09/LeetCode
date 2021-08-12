class Solution {
    public int minPairSum(int[] nums) {
        //최대값을 최소화 하기
        int answer = 0;
        // 1. 정렬
        Arrays.sort(nums);
        int n = nums.length;
        // 2. 가장 작은 수 + 큰 수 값 비교
        for(int i = 0; i < n / 2; i++){
            int sum = nums[i] + nums[n - 1 - i];
            answer = Math.max(answer, sum);
        }
        
        return answer;
        
    }
}