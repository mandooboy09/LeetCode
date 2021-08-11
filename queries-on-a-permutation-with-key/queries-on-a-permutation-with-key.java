class Solution {
    public int[] processQueries(int[] queries, int m) {
        int n = queries.length;
        int[] answer = new int[n];
        
        ArrayList<Integer> P = new ArrayList<>();
        for(int i = 1; i <= m; i++){
            P.add(i);
        }
        
        for(int i = 0; i < n; i++){
            int query = queries[i];
            int index = P.indexOf(query);
            answer[i] = index;
            
            int element = P.remove(index);
            P.add(0, element);
        }
        return answer;
    }
}