class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        
        String strNum = Integer.toString(x);
        int len = strNum.length();
        
        for(int i = 0; i < len / 2; i += 1){
            if(strNum.charAt(i) != strNum.charAt(len - 1 - i)){
                return false;
            }
        }
        
        return true;
    }
}