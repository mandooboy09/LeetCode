class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Histogram> stack = new Stack<>();
        int n = heights.length;
        stack.push(new Histogram(-1,-1));
        int answer = 0;

        for(int i = 0; i < n; i++){
            Histogram histogram = new Histogram(i, heights[i]);
            
            while(stack.peek().height >= histogram.height){
                Histogram lh = stack.pop();
                Histogram bh = stack.peek();
                int width = histogram.left - bh.right;
                int height = lh.height;
                int area = width * height;
                
                // System.out.printf("%d %d %d\n", histogram.index, width, height);
                
                answer = Math.max(answer, area);
            }
            stack.push(histogram);
        }
        
        while(!stack.isEmpty()){
            Histogram histogram = stack.pop();
            int width = n - histogram.left;
            if(!stack.isEmpty()){
                width = n - stack.peek().right;
            }
             
            int area = histogram.height * width;
            
            answer = Math.max(answer, area);
        }
        
        return answer;
    }
}

class Histogram{
    int left; 
    int right;
    int height;
    
    public Histogram(int left, int height){
        this.left = left;
        this.right = left + 1;
        this.height = height;
    }
}
