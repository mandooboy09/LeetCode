class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> answer = new ArrayList<>();
        int n = groupSizes.length;
        ArrayList<Integer>[] groups = new ArrayList[n + 1];

        for(int i = 1; i <= n; i++){
            groups[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < n; i++){
            int size = groupSizes[i];
            groups[size].add(i);
            
            if(groups[size].size() == size){
                answer.add(groups[size]);
                groups[size] = new ArrayList<>();
            }
        }

        return answer;
    }
}
