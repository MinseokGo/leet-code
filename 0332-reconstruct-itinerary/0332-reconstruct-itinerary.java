class Solution {

    private List<String> answer = new ArrayList<>();
    private Map<String, PriorityQueue<String>> map = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            PriorityQueue<String> pq = map.get(ticket.get(0));
            if (pq == null) {
                pq = new PriorityQueue<>();
                map.put(ticket.get(0), pq);
            }
            pq.add(ticket.get(1));
        }
        dfs("JFK");
        Collections.reverse(answer);
        return answer;
    }

    private void dfs(String airport) {
        PriorityQueue<String> pq = map.get(airport);
        if (pq != null) {
            while (!pq.isEmpty()) {
                dfs(pq.poll());
            }
        }
        answer.add(airport);
    }
}
