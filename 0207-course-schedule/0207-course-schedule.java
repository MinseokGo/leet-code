class Solution {

    private List<List<Integer>> graph = new ArrayList<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
            indegree[prerequisite[0]] += 1;
        }

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (queue.size() > 0) {
            int job = queue.poll();
            List<Integer> preJobs = graph.get(job);

            for (int preJob : preJobs) {
                indegree[preJob] -= 1;
                if (indegree[preJob] == 0) {
                    queue.add(preJob);
                }
            }
        }

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
