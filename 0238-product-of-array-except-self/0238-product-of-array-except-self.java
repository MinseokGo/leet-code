class Solution {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        int current = 1;
        for (int i = 0; i < n; i++) {
            answer[i] = current;
            current *= nums[i];
        }

        current = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= current;
            current *= nums[i]; 
        }

        return answer;
    }
}
