class Solution {
    public static char OPEN = '(';
    public static char CLOSE = ')';

    public void generateParenthesis(List<String> list, String str, int openCount, int closeCount){
        if(openCount > closeCount){
            return;
        }
        
        if(openCount == 0 && closeCount == 0){
            list.add(str);
            return;
        }
        
        if(openCount > 0){
            str += OPEN;
            generateParenthesis(list, str, openCount - 1, closeCount);
            str = str.substring(0, str.length()-1);
        }

        if(closeCount > 0){
            str += CLOSE;
            generateParenthesis(list, str, openCount, closeCount - 1);
            str = str.substring(0, str.length()-1);
        }        
        
        return;
    }
    
    public List<String> generateParenthesis(int n) {
        char[] arr = new char[n * 2];
        String str = "";
        boolean[] visited = new boolean[n * 2];
        for(int i = 0; i < n; i++){
            arr[i] = '(';
        }
        for(int i = n; i < n * 2; i++){
            arr[i] = ')';
        }
        
        List<String> list = new ArrayList<>();
        generateParenthesis(list, str, n, n);
        return list;
    }
}