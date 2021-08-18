class Solution {
    public static final int RED = 0;
    public static final int WHITE = 1;
    public static final int BLUE = 2;
    
    public void sortColors(int[] nums) {
        Queue<Integer> redQueue = new LinkedList<>();
        Queue<Integer> whiteQueue = new LinkedList<>();
        Queue<Integer> blueQueue = new LinkedList<>();
        
        for(int num : nums){
            if(num == RED){
                redQueue.add(num);
            }
            else if(num == WHITE){
                whiteQueue.add(num);
            }
            else if(num == BLUE){
                blueQueue.add(num);
            }
        }

        int i = 0;
        while(!redQueue.isEmpty()){
            nums[i++] = redQueue.poll();
        }
        while(!whiteQueue.isEmpty()){
            nums[i++] = whiteQueue.poll();
        }
        while(!blueQueue.isEmpty()){
            nums[i++] = blueQueue.poll();
        }        
        
    }
}