class Solution {
    public int countLargestGroup(int n) {
        int[] groupCounts = new int[37]; // Max digit sum for 9999 is 9+9+9+9=36

        for (int i = 1; i <= n; i++) {
            int sum = digitSum(i);
            groupCounts[sum]++;
        }

        int maxSize = 0;
        for (int count : groupCounts) {
            maxSize = Math.max(maxSize, count);
        }

        int result = 0;
        for (int count : groupCounts) {
            if (count == maxSize) {
                result++;
            }
        }

        return result;
    }

    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}