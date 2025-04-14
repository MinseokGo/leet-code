class Solution {

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            while (deque.size() > 0 && temperatures[i] > temperatures[deque.peekLast()]) {
                int index = deque.pollLast();
                answer[index] = i - index;
            }
            deque.addLast(i);
        }

        return answer;
    }
}
