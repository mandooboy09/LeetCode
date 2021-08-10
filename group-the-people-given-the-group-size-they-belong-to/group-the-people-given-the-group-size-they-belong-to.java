class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> answer = new LinkedList<>();
        int n = groupSizes.length;
        
        //그룹사이즈를 key로 갖고 값을 personId의 리스트를 value로 갖는 HashMap 세팅
        HashMap<Integer, LinkedList<Integer>> hashMap = new HashMap<>();
        for(int personId = 0; personId < n; personId++){
            int groupSize = groupSizes[personId];
            
            if(!hashMap.containsKey(groupSize)){
                hashMap.put(groupSize, new LinkedList<Integer>());
            }
            
            LinkedList<Integer> linkedList = hashMap.get(groupSize);
            linkedList.add(personId);
        }

        //그룹사이즈별 그룹화
        for(int key: hashMap.keySet()){
            // ArrayList<Integer> groupList = new ArrayList<>();
            LinkedList<Integer> linkedList = hashMap.get(key);
            LinkedList<Integer> splitGroup = new LinkedList<>();

            for(int i = 0; i < linkedList.size(); i++){
                splitGroup.add(linkedList.get(i));
                
                if(splitGroup.size() == key){
                    answer.add(splitGroup);
                    splitGroup = new LinkedList<Integer>();
                }
            }
        }
        return answer;
    }
}