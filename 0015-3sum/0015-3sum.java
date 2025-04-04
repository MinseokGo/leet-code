class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    answer.add(List.of(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) {
                        left += 1;
                    }

                    while (left < right && nums[right] == nums[right - 1]) {
                        right -= 1;
                    }

                    left += 1;
                    right -= 1;
                } else if (sum < 0) {
                    left += 1;
                } else {
                    right -= 1;
                }
            }
        }

        return answer;
    }
}