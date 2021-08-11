class Solution {
    public int minOperations(int n) {
        int answer = 0;
        int[] arr = new int[n];
        int sum = 0;
        int avg = 0;
        for(int i = 0; i < n; i++){
            arr[i] = i * 2 + 1;
            sum += arr[i];
        }
        
        avg = sum / n;
        
        for(int i = 0; i < n / 2; i++){
            answer += (avg - arr[i]);
        }
        
        return answer;
    }
}