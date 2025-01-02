class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] arr = new int[n+1];
        Set<Character> vowel = new HashSet<>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');
        for (int i = 0; i < n; i++) {
            if (isVowel(words[i].charAt(0),words[i].charAt(words[i].length() - 1))) {
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
    public boolean isVowel(char ch1,char ch2){
        if((ch1=='a'||ch1=='e'||ch1=='i'||ch1=='o'||ch1=='u')&&(ch2=='a'||ch2=='e'||ch2=='i'||ch2=='o'||ch2=='u')){
            return true;
        }
        return false;
    }
}