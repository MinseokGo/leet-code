class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        int[] counts = new int[20001];

        for (ListNode list : lists) {
            while (list != null) {
                counts[list.val + 10000] += 1;
                list = list.next;
            }
        }

        ListNode answer = new ListNode(-1);
        ListNode copy = answer;
        for (int i = 0; i < counts.length; i++) {
            int count = counts[i];
            for (int j = 0; j < count; j++) {
                copy.next = new ListNode(i - 10000);
                copy = copy.next;
            }
        }

        return answer.next;
    }
}
