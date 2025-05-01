class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int ans=0;
        int l=0,r=tasks.length,w=workers.length;
        while(l<=r){
            int mid=l+(r-l)/2;
            boolean canSolve=solve(tasks,workers,pills,strength,mid);
            if(canSolve){
                ans=mid;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return ans;
    }
    private boolean solve(int[] tasks, int[] workers, int pillsLeft, int strength, int k) {
    TreeMap<Integer, Integer> sortedWorkers = new TreeMap<>();
    for (int i = workers.length - k; i < workers.length; ++i)
      sortedWorkers.merge(workers[i], 1, Integer::sum);

    for (int i = k - 1; i >= 0; --i) {
      Integer lo = sortedWorkers.ceilingKey(tasks[i]);
      if (lo != null) {
        sortedWorkers.merge(lo, -1, Integer::sum);
        if (sortedWorkers.get(lo) == 0) {
          sortedWorkers.remove(lo);
        }
      } else if (pillsLeft > 0) {
        lo = sortedWorkers.ceilingKey(tasks[i] - strength);
        if (lo != null) {
          sortedWorkers.merge(lo, -1, Integer::sum);
          if (sortedWorkers.get(lo) == 0) {
            sortedWorkers.remove(lo);
          }
          --pillsLeft;
        } else {
          return false;
        }
      } else {
        return false;
      }
    }

    return true;
  }

}