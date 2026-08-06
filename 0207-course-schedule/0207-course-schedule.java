class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        int[] indegrees =  new int[numCourses];

        // build graph
        for(int i = 0;i<prerequisites.length;i++) {
            int course = prerequisites[i][0];
            int preprerequisite = prerequisites[i][1];
            graph.get(preprerequisite).add(course);
            indegrees[course]++;
        }

        //Topo sort
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i<numCourses;i++) {
            if(indegrees[i] == 0){
                queue.offer(i);
            }
        }

        int completed = 0;
        while(!queue.isEmpty()) {
            int current = queue.poll();
            completed++;
            for(int next : graph.get(current)) {
                indegrees[next]--;
                if(indegrees[next] == 0){
                    queue.offer(next);
                }
            }
        }
        return completed == numCourses;
    }
}