class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int answer[] = new int[n];
        
        
        for(int i = 0; i < n; i++){
            int operationCount = 0;
            for(int j = 0; j < n; j++){
                if(i != j && boxes.charAt(j) == '1'){
                    operationCount += Math.abs(j - i);
                }
            }
            answer[i] = operationCount;
        }
        
        return answer;
    }
}