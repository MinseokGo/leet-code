class Solution {

    public String removeDuplicateLetters(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        int[] counts = new int[26];
        boolean[] seen = new boolean[26];

        char[] chars = s.toCharArray();
        for (char ch : chars) {
            counts[ch - 97] += 1;
        }

        for (char ch : chars) {
            counts[ch - 97] -= 1;
            if (!seen[ch - 97]) {
                seen[ch - 97] = true;
                while (deque.size() > 0) {
                    if (deque.peekLast() > ch && counts[deque.peekLast() - 97] > 0) {
                        char remove = deque.pollLast();
                        seen[remove - 97] = false;;
                    } else {
                        break;
                    }
                }
                deque.addLast(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (deque.size() > 0) {
            sb.append(deque.pollFirst());
        }
        
        return sb.toString();
    }
}
