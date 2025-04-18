class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.val, b.val)
        );

        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        ListNode answer = new ListNode(-1);
        ListNode tail = answer;
        while (pq.size() > 0) {
            ListNode current = pq.poll();
            tail.next = current;
            tail = tail.next;

            if (current.next != null) {
                pq.add(current.next);
            }
        }

        return answer.next;
    }
}
