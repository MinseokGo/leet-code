class Solution {

    public int lengthOfLongestSubstring(String s) {
        int[] ascii = new int[128];
        int start = 0;
        int longest = 0;

        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            start = Math.max(start, ascii[ch]);
            longest = Math.max(longest, end - start + 1);
            ascii[ch] = end + 1;
        }
        return longest;
    }
}
