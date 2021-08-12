class Solution {
    public void search(int[] nums, int depth, ArrayList<Integer> list, List<List<Integer>> answer, boolean[] visited){
        //base case
        if(depth == nums.length){
            answer.add(new ArrayList(list));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            
            list.add(nums[i]);
            search(nums, depth + 1, list, answer, visited);
            list.remove(list.size() - 1);
            
            visited[i] = false;
            
        }
        
        return;
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        
        search(nums, 0, list, answer, visited);
        
        return answer;
    }
}
