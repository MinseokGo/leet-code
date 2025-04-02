class Solution {

    public String[] reorderLogFiles(String[] logs) {
        List<String> letters = new ArrayList<>();
        List<String> digits = new ArrayList<>();

        for (String log : logs) {
            String[] splitedLog = log.split(" ");

            if (Character.isLetter(splitedLog[1].charAt(0))) {
                letters.add(log);
            } else {
                digits.add(log);
            }
        }

        Collections.sort(letters, (s1, s2) -> {
            int index1 = findLogStartIndex(s1);
            int index2 = findLogStartIndex(s2);

            String sub1 = s1.substring(index1);
            String sub2 = s2.substring(index2);

            if (!sub1.equals(sub2)) {
                return sub1.compareTo(sub2);
            }
            return s1.compareTo(s2);
        });

        letters.addAll(digits);

        return letters.toArray(new String[0]);
    }

    private int findLogStartIndex(String str) {
        char[] chars = str.toCharArray();
        for (int i  = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                return i + 1;
            }
        }
        return -1;
    }
}