class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] arr = new int[100001];
        int n = words.length;
        Set<Character> vowel = new HashSet<>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');
        for (int i = 0; i < n; i++) {
            if (vowel.contains(words[i].charAt(0)) && vowel.contains(words[i].charAt(words[i].length() - 1))) {
                arr[i] = 1;
            }
            if (i != 0) {
                arr[i] = arr[i] + arr[i - 1];
            }
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (queries[i][0] == 0) {
                ans[i] = arr[queries[i][1]];
            } else {
                ans[i] = arr[queries[i][1]] - arr[queries[i][0] - 1];
            }
        }
        return ans;
    }
}