import java.util.*;

class Solution {

    public String longestPalindrome(String s) {
        String longest = "";

        for (int i = 0; i < s.length(); i++) {
            String odd = findPalindromSubstring(s, i, i);
            String even = findPalindromSubstring(s, i, i + 1);

            if (odd.length() > longest.length()) {
                longest = odd;
            }
            if (even.length() > longest.length()) {
                longest = even;
            }
        }

        return longest;
    }

    private String findPalindromSubstring(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left -= 1;
            right += 1;
        }
        return s.substring(left + 1, right);
    }
}