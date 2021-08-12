class Solution {
    
    public void searchSubsets(int[] nums, List<List<Integer>> answer, ArrayList<Integer> list, int depth, int maxDepth, boolean[] visited, int begin){
        if(depth == maxDepth){
            answer.add(new ArrayList<>(list));
            return;
        }
        
        if(begin > nums.length){
            return;
        }
        
        
        for(int i = begin; i < nums.length; i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            
            list.add(nums[i]);
            searchSubsets(nums, answer, list, depth + 1, maxDepth, visited, i + 1);
            list.remove(list.size() - 1);
            
            visited[i] = false;
            
        }
        
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> answer = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        int depth = nums.length;
        
        for(int i = 0; i <= depth; i++){
            searchSubsets(nums, answer, list, 0, i, visited, 0);
        }
        
        return answer;
        
    }
}