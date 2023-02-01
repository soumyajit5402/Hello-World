class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> container = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                int first = container.pop();
                int second = container.pop();
                container.push(second + first);
            } else if (token.equals("-")) {
                int first = container.pop();
                int second = container.pop();
                container.push(second - first);
            } else if (token.equals("*")) {
                int first = container.pop();
                int second = container.pop();
                container.push(second * first);
            } else if (token.equals("/")) {
                int first = container.pop();
                int second = container.pop();
                container.push(second / first);
            } else {
                container.push(Integer.parseInt(token));
            }
        }
        return container.pop();
    }
}