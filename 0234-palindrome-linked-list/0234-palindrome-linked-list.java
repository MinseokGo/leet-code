/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public boolean isPalindrome(ListNode head) {
        List<Integer> numbers = new ArrayList<>();

        while (head != null) {
            numbers.add(head.val);
            head = head.next;
        }

        int left = 0;
        int right = numbers.size() - 1;
        while (left < right) {
            if (numbers.get(left) != numbers.get(right)) {
                return false;
            }
            left += 1;
            right -= 1;
        }

        return true;
    }
}
