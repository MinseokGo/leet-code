class Solution {

    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>();
        Map<String, Integer> wordsMap = new HashMap<>();

        for (String str : banned) {
            bannedSet.add(str.toLowerCase());
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : paragraph.toLowerCase().toCharArray()) {
            if (Character.isLetter(ch)) {
                sb.append(ch);
            } else if (sb.length() > 0) {
                String str = sb.toString();
                if (!bannedSet.contains(str)) {
                    wordsMap.put(str, wordsMap.getOrDefault(str, 0) + 1);
                    sb.setLength(0);
                } else {
                    sb.setLength(0);
                }
            }
        }

        if (sb.length() != 0) {
            String str = sb.toString();
            wordsMap.put(str, wordsMap.getOrDefault(str, 0) + 1);
        }

        Map.Entry<String, Integer> max = null;
        for (Map.Entry<String, Integer> entry : wordsMap.entrySet()) {
            if (max == null || entry.getValue() > max.getValue()) {
                max = entry;
            }
        }

        return max.getKey();
    }
}
