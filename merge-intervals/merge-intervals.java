class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(o1, o2) -> {
           if(o1[0] == o2[0]){
               return Integer.compare(o1[1],o2[1]);
           }
            else{
                return Integer.compare(o1[0],o2[0]);
            }
        });
        
        int n = intervals.length;
        int start = intervals[0][0];
        int end = intervals[0][1];
        ArrayList<Point2D> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int newStart = intervals[i][0];
            int newEnd = intervals[i][1];
            
            if(newStart > end){
                list.add(new Point2D(start, end));
                start = newStart;
                end = newEnd;
            }
            else if(newEnd > end){
                end = newEnd;
            }
            
            if(i == n - 1){
                list.add(new Point2D(start, end));
            }
        }
        
        int len = list.size();
        int[][] answer = new int[len][2];
        
        int i = 0;
        for(Point2D point : list){
            answer[i][0] = point.start;
            answer[i][1] = point.end;
            i++;
        }
        
        return answer;
    }
}

class Point2D{
    int start;
    int end;
    
    public Point2D(int start, int end){
        this.start = start;
        this.end = end;
    }
}
