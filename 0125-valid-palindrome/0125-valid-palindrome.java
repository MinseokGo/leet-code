class Solution {

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        s = s.toLowerCase();
        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch) || Character.isDigit(ch)) {
                sb.append(String.valueOf(ch));
            }
        }

        s = sb.toString();
        int left = 0;
        int right = s.length() - 1;
        boolean isPalindrome = true;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                isPalindrome = false;
                break;
            }
        }

        return isPalindrome ? true : false;
    }
}