class Solution {
     List<Integer> ans = new ArrayList<>();

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums); 
        List<Integer> list = new ArrayList<>();
        solve(nums, list, nums.length - 1);
        return ans;
    }

    public void solve(int[] nums, List<Integer> list, int ind) {
        if (ind < 0) {
            if (list.size() > ans.size()) {
                ans = new ArrayList<>(list); 
            }
            return;
        }

        boolean canTake = true;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % nums[ind] != 0 && nums[ind] % list.get(i) != 0) {
                canTake = false;
                break;
            }
        }

        if (canTake) {
            list.add(nums[ind]);
            solve(nums, list, ind - 1);
            list.remove(list.size() - 1); // backtrack
        }
        solve(nums, list, ind - 1);
    }
}