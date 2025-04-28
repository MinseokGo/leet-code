class Solution {

    private int length;
    private List<List<Integer>> combinations = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        length = nums.length;
        dfs(nums, 0);
        return combinations;
    }

    private void dfs(int[] nums, int start) {
        if (start == length) {
            List<Integer> combination = new ArrayList<>();
            for (int num : nums) {
                combination.add(num);
            }
            combinations.add(combination);
            return;
        }

        for (int i = start; i < length; i++) {
            swap(nums, i, start);
            dfs(nums, start + 1);
            swap(nums, i, start);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
