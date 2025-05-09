class Solution {

    public int findKthLargest(int[] nums, int k) {
        int[] counts = new int[20001];
        int answer = 0;

        for (int num : nums) {
            counts[num + 10000] += 1;
        }

        for (int i = counts.length - 1; i >= 0; i--) {
            if (k - counts[i] <= 0) {
                answer = i - 10000;
                break;
            }
            k -= counts[i];
        }

        return answer;
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // for (int num : nums) {
        //     pq.add(num);
        // }

        // for (int i = 0; i < k - 1; i++) {
        //     pq.poll();
        // }

        // return pq.poll();
    }
}
