class Solution {

    private static final Map<Character, List<String>> map = Map.of(
        '2', List.of("a", "b", "c"),
        '3', List.of("d", "e", "f"),
        '4', List.of("g", "h", "i"),
        '5', List.of("j", "k", "l"),
        '6', List.of("m", "n", "o"),
        '7', List.of("p", "q", "r", "s"),
        '8', List.of("t", "u", "v"),
        '9', List.of("w", "x", "y", "z")
    );

    private int length;
    private List<String> answer = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        length = digits.length();
        if (length == 0) {
            return new ArrayList<>();
        }
        
        char[] chars = digits.toCharArray();
        dfs(chars, 0, new StringBuilder());

        return answer;
    }

    private void dfs(char[] chars, int index, StringBuilder combination) {
        if (index == length) {
            answer.add(combination.toString());
            return;
        }

        char ch = chars[index];
        List<String> alphabets = map.get(ch);
        for (int i = 0; i < alphabets.size(); i++) {
            combination.append(alphabets.get(i));
            dfs(chars, index + 1, combination);
            combination.deleteCharAt(combination.length() - 1);
        }
    }
}
