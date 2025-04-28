class Solution {

    private int N;
    private int K;
    private boolean[] visited;
    private List<List<Integer>> combinations = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        N = n;
        K = k;
        visited = new boolean[n + 1];
        dfs(new ArrayList<>(), 1, 0);
        return combinations;
    }

    private void dfs(List<Integer> combination, int start, int size) {
        if (size == K) {
            combinations.add(new ArrayList<>(combination));
            return;
        }

        for (int i = start; i <= N; i++) {
            combination.add(i);
            dfs(combination, i + 1, size + 1);
            combination.removeLast();
        }
    }
}
