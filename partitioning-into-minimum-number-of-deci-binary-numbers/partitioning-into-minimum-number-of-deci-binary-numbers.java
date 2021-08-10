class Solution {
    public int minPartitions(String n) {
        char[] arrChar = n.toCharArray();
        int len = arrChar.length;

        int answer = 0;
        for(int i = 0; i < len; i++){
            int digit = Character.getNumericValue(arrChar[i]);
            
            if(answer > digit){
                continue;
            }
            
            answer += (digit - answer);
            
            if(answer == 9){
                break;
            }
        }
        return answer;
    }
}