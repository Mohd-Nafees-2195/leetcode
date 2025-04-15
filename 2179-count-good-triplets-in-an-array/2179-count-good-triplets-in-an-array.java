class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] pos = new int[n];
        
        // Map each number to its index in nums1
        for (int i = 0; i < n; i++) {
            pos[nums1[i]] = i;
        }

        // Create transformed array
        int[] indexArray = new int[n];
        for (int i = 0; i < n; i++) {
            indexArray[i] = pos[nums2[i]];
        }

        // BIT (Fenwick Tree)
        BIT left = new BIT(n);
        BIT right = new BIT(n);

        // Count occurrences on the right (initially full array)
        for (int i = 0; i < n; i++) {
            right.update(indexArray[i], 1);
        }

        long count = 0;
        for (int j = 0; j < n; j++) {
            int val = indexArray[j];
            right.update(val, -1); // Remove current value from right

            long leftCount = left.query(val - 1);      // i < j and nums1[i] < nums1[j]
            long rightCount = right.query(n - 1) - right.query(val); // k > j and nums1[k] > nums1[j]

            count += leftCount * rightCount;

            left.update(val, 1); // Add current value to left
        }

        return count;
    }

    class BIT {
        long[] tree;
        int n;

        public BIT(int size) {
            n = size + 2;
            tree = new long[n];
        }

        public void update(int index, int delta) {
            index++;
            while (index < n) {
                tree[index] += delta;
                index += index & -index;
            }
        }

        public long query(int index) {
            index++;
            long sum = 0;
            while (index > 0) {
                sum += tree[index];
                index -= index & -index;
            }
            return sum;
        }
    }

}