class Solution {

    public int[][] kClosest(int[][] points, int k) {
        int[][] answer = new int[k][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (i1, i2) -> Integer.compare(
                calculateDistance(i1),
                calculateDistance(i2)
            )
        );

        for (int[] point : points) {
            pq.add(point);
        }

        for (int i = 0; i < k; i++) {
            answer[i] = pq.poll();
        }

        return answer;
    }

    private int calculateDistance(int[] point) {
        return (point[0] * point[0]) + (point[1] * point[1]);
    }
}
