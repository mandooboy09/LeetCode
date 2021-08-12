class Solution {
    public void search(int[] nums, LinkedList<Integer> list, List<List<Integer>> answer){
        //base case
        if(list.size() == nums.length){
            answer.add(new LinkedList(list));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(list.contains(nums[i])){
                continue;
            }
            
            list.add(nums[i]);
            
            search(nums, list, answer);
            
            list.remove(list.size() - 1);
            
        }
        
        return;
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        
        search(nums, list, answer);
        
        return answer;
    }
}