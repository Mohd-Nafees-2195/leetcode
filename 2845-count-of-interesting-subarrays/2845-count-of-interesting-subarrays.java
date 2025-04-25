class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
       Map<Integer, Long> map = new HashMap<>();
        map.put(0, 1L); // Initialize with 0 count
        
        long result = 0;
        int count = 0;

        for (int num : nums) {
            if (num % modulo == k) {
                count++;
            }
            int currMod = count % modulo;
            // Find how many times (currMod - k + modulo) % modulo has occurred
            int target = (currMod - k + modulo) % modulo;
            result += map.getOrDefault(target, 0L);
            map.put(currMod, map.getOrDefault(currMod, 0L) + 1);
        }

        return result;
    }
}