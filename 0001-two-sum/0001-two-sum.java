class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // <number, index>

        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            if (map.containsKey(number)) {
                return new int[] {map.get(number), i};
            }
            map.put(target - number, i);
        }
        
        return new int[] {0, 0};
    }
}