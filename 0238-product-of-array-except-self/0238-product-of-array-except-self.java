class Solution {

    public int[] productExceptSelf(int[] nums) {
        int zero = 0;
        int index = -1;
        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zero += 1;
                index = i;
            } else {
                prefix *= nums[i];
            }
        }

        int[] answer = new int[nums.length];
        if (zero == 1) {
            answer[index] = prefix;
            return answer;
        }

        if (zero >= 2) {
            return answer;
        }

        for (int i = 0; i < nums.length; i++) {
            answer[i] = prefix / nums[i];
        }

        return answer;
    }
}
