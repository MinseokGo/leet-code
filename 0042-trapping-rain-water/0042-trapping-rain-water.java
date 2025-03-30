class Solution {
    
    public int trap(int[] heights) {
        int sum = 0;
        int left = 0;
        int right = heights.length - 1;

        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        while (left < right) {
            leftMax = Math.max(leftMax, heights[left]);
            rightMax = Math.max(rightMax, heights[right]);

            sum += (leftMax < rightMax) ? (leftMax - heights[left++]) : (rightMax - heights[right--]);
        }

        return sum;
    }
}