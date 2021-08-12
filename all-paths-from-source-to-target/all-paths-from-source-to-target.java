class Solution {
    public void allPath(int[][] graph, List<List<Integer>> answer, ArrayList<Integer> path, int node){
        //base case
        if(node == graph.length - 1){
            answer.add(new ArrayList(path));
            return;
        }
        
        int n = graph[node].length;
        for(int i = 0; i < n; i++){
            int next = graph[node][i];
            path.add(next);
            allPath(graph, answer, path, next);
            path.remove(path.size() - 1);
        }
        return;
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> answer = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        path.add(0);
        allPath(graph, answer, path, 0);
        return answer;
    }
}