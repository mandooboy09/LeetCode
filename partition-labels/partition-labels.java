class Solution {

    public List<Integer> partitionLabels(String s) {
        List<Integer> answer = new ArrayList<>();
        int[] last = new int[26];
        
        for(int i = 0; i < s.length(); i++){
            last[s.charAt(i) - 'a'] = i;
        }
        
        int dest = 0;
        int anchor = 0;
        
        for(int i = 0; i < s.length(); i++){
            dest = Math.max(dest, last[s.charAt(i)- 'a']);
            
            if(i == dest){
                answer.add(dest - anchor + 1);
                anchor = dest + 1;
            }
        }
        
        return answer;
    }
}