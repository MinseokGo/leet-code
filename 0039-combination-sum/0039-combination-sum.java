class Solution {

    private int length;
    private List<List<Integer>> combinations = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        length = candidates.length;
        dfs(candidates, 0, new ArrayList<>(), 0, target);
        return combinations.stream().toList();
    }

    private void dfs(int[] candidates, int start, List<Integer> combination, int sum, int target) {
        if (sum == target) {
            combinations.add(new ArrayList<>(combination));
            return;
        }

        for (int i = start; i < length; i++) {
            int number = candidates[i];
            if (sum + number <= target) {
                combination.add(number);
                dfs(candidates, i, combination, sum + number, target);
                combination.removeLast();
            }
        }
    }
}
