class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] answer = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offer(i);

            if (i >= k - 1) {
                answer[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return answer;
    }
}
