class Solution {
    public int extendPalindrome(String s, int left, int right){
        int count = 0;
        
        int n = s.length();
        
        while(left >= 0 && right < n){
            if(s.charAt(left--) != s.charAt(right++)){
                break;
            }
            count++;
        }
        return count;
    }
    public int countSubstrings(String s) {
        int answer = 0;
        
        for(int i = 0; i < s.length(); i++){
            answer += extendPalindrome(s, i, i);
            answer += extendPalindrome(s, i, i + 1);
        }
        
        return answer;
    }
}