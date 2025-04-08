class Solution {

    public int arrayPairSum(int[] nums) {
        int[] count = new int[20001];

        for (int num : nums) {
            count[num + 10000] += 1;
        }

        int sum = 0;
        boolean isAdd = true;
        for (int i = 0; i < count.length; i++) {
            while (count[i]-- > 0) {
                if (isAdd) {
                    sum += i - 10000;
                }
                isAdd = !isAdd;
            }
        }

        return sum;
    }
}
