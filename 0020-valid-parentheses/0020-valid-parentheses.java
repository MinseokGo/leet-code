class Solution {

    private static final Map<Character, Character> brackets = Map.of(
            ')', '(',
            '}', '{',
            ']', '['
    );

    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                deque.addLast(ch);
            } else {
                if (brackets.get(ch) != deque.pollLast()) {
                    return false;
                }
            }
        }

        if (deque.size() > 0) {
            return false;
        }

        return true;
    }
}
