class Solution {
    public int numSquares(int n) {
        int answer = 0;
        Queue<Integer> bfsQueue = new LinkedList<>();
        
        if(n > 0){
            bfsQueue.add(n);
        }
        
        boolean flag = false;
        
        while(!bfsQueue.isEmpty()){
            int size = bfsQueue.size();
            
            for(int i = 0; i < size; i++){
                int num = bfsQueue.poll();
                int sqrt = (int) Math.sqrt(num);
                
                for(int j = sqrt; j >= 1; j--){
                    if(j * j == num){
                        flag = true;
                        break;
                    }
                    
                    bfsQueue.add(num - j*j);
                }
                if(flag){
                    break;
                }
            }
            answer += 1;
            if(flag){
                break;
            }
        }
        return answer;
    }
}