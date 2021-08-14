class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int[] frequent = new int[n];
        int answer = 0;
        
        // 각 정수의 빈도수 기록
        for(int i = 0; i < n; i++){
            int num = nums[i];
            frequent[num] += 1;
        }
        
        // 빈도수 2이상인 정수 탐색
        for(int i = 1; i < n; i++){
            if(frequent[i] >= 2){
                answer = i;
                break;
            }
        }
        
        return answer;
        
    }
}