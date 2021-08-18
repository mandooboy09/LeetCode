class Solution {
    String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public void search(HashSet<String> set, String str, String digits, int depth){
        if(depth == digits.length()){
            set.add(str);
            return;
        }
        
        int num = Character.getNumericValue(digits.charAt(depth));
        
        for(int i = 0; i < letters[num].length(); i++){
            char c = letters[num].charAt(i);
            str += c;
            
            search(set, str, digits, depth + 1);
                
            str = str.substring(0,str.length()- 1);
        }
        
    }
    public List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        
        if(digits.length() == 0){
            return answer;
        }
        
        search(set, "", digits, 0);
        
        for(String str : set){
            answer.add(str);
        }
        return answer;
    }
}