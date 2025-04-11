class Solution {

    public String removeDuplicateLetters(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int[] count = new int[26];
        boolean[] seen = new boolean[26];

        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        for (char ch : s.toCharArray()) {
            int idx = ch - 'a';
            count[idx]--;

            if (seen[idx]) continue;

            while (
                !stack.isEmpty() &&
                stack.peekLast() > ch &&
                count[stack.peekLast() - 'a'] > 0
            ) {
                char removed = stack.pollLast();
                seen[removed - 'a'] = false;
            }

            stack.addLast(ch);
            seen[idx] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            sb.append(ch);
        }

        return sb.toString();
    }
}
