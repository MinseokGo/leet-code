class Solution {

    public int numJewelsInStones(String jewels, String stones) {
        int answer = 0;
        Set<Character> set = new HashSet<>();

        for (char jewel : jewels.toCharArray()) {
            set.add(jewel);
        }

        for (char stone : stones.toCharArray()) {
            if (set.contains(stone)) {
                answer += 1;
            }
        }
        return answer;
    }
}
