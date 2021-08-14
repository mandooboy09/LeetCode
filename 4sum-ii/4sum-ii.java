class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        int answer = 0;
        // 한쌍의 짝을 만든다
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int key1 = nums1[i] + nums2[j];
                int key2 = nums3[i] + nums4[j];
                
                if(!map1.containsKey(key1)){
                    map1.put(key1,0);
                }
                if(!map2.containsKey(key2)){
                    map2.put(key2,0);
                }
                int count1 = map1.get(key1);
                int count2 = map2.get(key2);
                
                map1.put(key1, count1 + 1);
                map2.put(key2, count2 + 1);
            }
        }
        
        for(int key1 : map1.keySet()){
            int value1 = map1.get(key1);
            int key2 = key1 * (-1);
            int value2 = 0;
            if(map2.containsKey(key2)){
                value2 = map2.get(key2);
            }
            
            answer += value1 * value2;
        }
        return answer;
    }
}

class Pair {
    int num1Index;
    int num2Index;
    
    int num1;
    int num2;
    int sumOfNum;
    
    public Pair(int num1Index, int num2Index, int num1, int num2){
        this.num1Index = num1Index;
        this.num2Index = num2Index;
        this.num1 = num1;
        this.num2 = num2;
        this.sumOfNum = num1 + num2;
    }
}