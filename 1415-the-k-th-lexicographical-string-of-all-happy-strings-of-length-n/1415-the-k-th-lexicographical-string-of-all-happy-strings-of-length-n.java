class Solution {
    public String getHappyString(int n, int k) {
       List<String> happyStrings = new ArrayList<>();
        generateHappyStrings(n, "", happyStrings);
        
        return k <= happyStrings.size() ? happyStrings.get(k - 1) : "";
    }
    private void generateHappyStrings(int n, String current, List<String> happyStrings) {
        if (current.length() == n) {
            happyStrings.add(current);
            return;
        }
        for (char ch : new char[]{'a', 'b', 'c'}) {
            if (current.isEmpty() || current.charAt(current.length() - 1) != ch) {
                generateHappyStrings(n, current + ch, happyStrings);
            }
        }
    }

}