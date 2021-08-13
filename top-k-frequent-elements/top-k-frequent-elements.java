class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] answers = new int[k];
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums){
            if(!map.containsKey(num)){
                map.put(num, 0);
            }
            
            int frequent = map.get(num);
            map.put(num, frequent + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (n1, n2) -> map.get(n1) - map.get(n2));
        
        for(int num : map.keySet()){
            pq.add(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        for(int i = 0; i < k; i++){
            answers[i] = pq.poll();
        }
        
        return answers;
               
    }
}