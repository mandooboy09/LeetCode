class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums){
            if(map.containsKey(num) == false){
                map.put(num, 0);
            }
            
            int val = map.get(num);
            map.put(num, val + 1);
        }
        
        int answer = 0;
        for(int key : map.keySet()){
            if(map.get(key) == 1){
                answer = key;
                break;
            }
        }
        
        return answer;
    }
}