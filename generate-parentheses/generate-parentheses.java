class Solution {

    public void bracket(List<String> arr, StringBuilder str, int open, int close, int max){
        //base case
        if(str.length() == max * 2){
            arr.add(str.toString());
            return;
        }
        
        if(open < max){
            str.append('(');
            bracket(arr, str, open + 1, close, max);
            str.setLength(str.length()-1);
        }

        if(close < open){
            str.append(')');
            bracket(arr, str, open, close + 1, max);
            str.setLength(str.length()-1);
        }        
        
        return;
    }
    
    public List<String> generateParenthesis(int n) {
        List<String> arr = new ArrayList<>();
        
        bracket(arr, new StringBuilder(), 0, 0, n);
        
        return arr;

    }
}
