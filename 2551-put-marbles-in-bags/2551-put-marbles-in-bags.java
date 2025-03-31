class Solution {
    public long putMarbles(int[] weights, int k) {
         if (k == 1) return 0; 

        int n = weights.length;
        List<Integer> pairSums = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            pairSums.add(weights[i] + weights[i + 1]);
        }

        Collections.sort(pairSums);

        int minCost = 0, maxCost = 0;
        int size = pairSums.size();

    
        for (int i = 0; i < k - 1; i++) {
            minCost += pairSums.get(i);        
            maxCost += pairSums.get(size - 1 - i); 
        }
        return maxCost - minCost;
    }
}