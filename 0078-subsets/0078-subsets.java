class Solution {

    private int length;
    private List<List<Integer>> combinations = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        length = nums.length;
        dfs(nums, 0, new ArrayList<>());
        return combinations;
    }

    private void dfs(int[] nums, int start, List<Integer> combination) {
        combinations.add(new ArrayList<>(combination));
        for (int i = start; i < length; i++) {
            combination.add(nums[i]);
            dfs(nums, i + 1, combination);
            combination.removeLast();
        }
    }
}
