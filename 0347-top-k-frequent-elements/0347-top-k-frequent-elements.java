class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        int[] counts = new int[20001];
        int[] answer = new int[k];
        PriorityQueue<NumberCount> pq = new PriorityQueue<>(
            (n1, n2) -> Integer.compare(n2.count, n1.count)
        );

        for (int num : nums) {
            counts[num + 10000] += 1;
        }

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                pq.add(new NumberCount(i - 10000, counts[i]));
            }
        }

        for (int i = 0; i < k; i++) {
            answer[i] = pq.poll().number;
        }
        
        return answer;
    }

    private static class NumberCount {
        int number;
        int count;

        NumberCount(int number, int count) {
            this.number = number;
            this.count = count;
        }
    }
}
