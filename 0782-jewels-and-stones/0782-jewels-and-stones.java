class Solution {

    public int numJewelsInStones(String jewels, String stones) {
        int answer = 0;

        for (char stone : stones.toCharArray()) {
            if (jewels.indexOf(stone) != -1) {
                answer += 1;
            }
        }
        return answer;
    }
}
