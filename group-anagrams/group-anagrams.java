class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answers = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        
        //같은 문자들로 구성된 문자열들을 묶어준다
        for(String str: strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortStr = new String(chars);
            if(!map.containsKey(sortStr)){
                map.put(sortStr, new ArrayList<>());
            }
            
            List<String> list = map.get(sortStr);
            list.add(str);
        }
        
        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            answers.add(entry.getValue());
        }
        return answers;
    }
}