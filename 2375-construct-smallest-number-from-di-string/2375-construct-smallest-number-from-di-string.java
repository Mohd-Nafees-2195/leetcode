class Solution {
    public String smallestNumber(String pattern) {
        StringBuilder result = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();
        int number = 1;

        for (char ch : pattern.toCharArray()) {
            stack.push(number++);
            if (ch == 'I') {
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
            }
        }
        stack.push(number);
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }
}