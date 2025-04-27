class Solution {

    private int length;
    private boolean[] visited;
    private List<List<Integer>> combinations = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        length = nums.length;
        visited = new boolean[length];

        dfs(nums, new ArrayList<>());
        return combinations;
    }

    private void dfs(int[] nums, List<Integer> combination) {
        if (combination.size() == length) {
            combinations.add(new ArrayList<>(combination));
            return;
        }

        for (int i = 0; i < length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination.add(nums[i]);
                dfs(nums, combination);
                visited[i] = false;
                combination.remove(combination.size() - 1);
            }
        }
    }
}
