class Solution {

    public List<List<String>> groupAnagrams(String[] words) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);

            String sorted = new String(chars);
            map.computeIfAbsent(
                    sorted,
                    k -> new ArrayList<>()
                ).add(word);
        }

        return map.values().stream()
                .collect(Collectors.toList());
    }
}