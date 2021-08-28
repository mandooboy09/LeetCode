class Solution {
    public int trap(int[] height) {
        int answer = 0;
        
        Stack<Bar> stack = new Stack<>();
        stack.push(new Bar(-1,0));
        
        for(int i = 0; i < height.length; i++) {
            Bar right = new Bar(i, height[i]);
            
            int offSet = 0;
            while(!stack.isEmpty() && stack.peek().h <= right.h){
                Bar left = stack.peek();
                int width = right.index - left.index - 1;
                answer += (left.h - offSet) * width;
                // System.out.printf("%d %d %d %d\n", i, answer, width, (left.h - offSet) );
                offSet = left.h;
                
                stack.pop();
            }
            
            if(!stack.isEmpty() && stack.peek().h > right.h){
                Bar left = stack.peek();
                int width = right.index - left.index - 1;
                answer += (right.h - offSet) * width;
            }            

            if(right.h != 0){
                stack.push(right);    
            }
        }
        
        return answer;
        
    }
}

class Bar{
    int index;
    int h;
    
    public Bar(int index, int h){
        this.index = index;
        this.h = h;
    }
}