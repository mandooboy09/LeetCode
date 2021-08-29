class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int answer = -1;
        int n = gas.length;
        boolean flag = false;
        
        for(int start = 0; start < n; start++){
            int dest = start - 1;
            if(dest == -1){
                dest = n - 1;
            }
            
            int index = start;
            int energy = gas[start];
            
            // next move possible?
            while(energy >= cost[index]){
                if(index == dest){
                    flag = true;
                    break;
                }
                // move;
                energy -= cost[index];
                
                index = (index + 1) % n;
                
                energy += gas[index];
            }
            
            if(flag){
                answer = start;
                break;
            }
        }
        
        return answer;
    }
}