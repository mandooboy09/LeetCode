class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int answer[] = new int[n];
        
        int leftCount = 0;
        int leftCost = 0;
        int rightCount = 0;
        int rightCost = 0;
        
        //leftCost
        for(int i = 1; i < n; i++){
            if(boxes.charAt(i - 1) == '1'){
                leftCount += 1;
            }
            leftCost += leftCount;
            answer[i] += leftCost;
        }
        
        //rightCost
        for(int i = n - 2; i >= 0; i--){
            if(boxes.charAt(i + 1) == '1'){
                rightCount += 1;
            }
            rightCost += rightCount;
            answer[i] += rightCost;
        }
        
        return answer;
    }
}
