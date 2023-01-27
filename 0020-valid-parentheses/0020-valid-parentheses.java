class Solution {
    public boolean isValid(String s) {
        Stack<Character> container = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') container.push(c);
            else if (c == ')' && !container.isEmpty() && container.peek() == '(') container.pop();
            else if (c == '}' && !container.isEmpty() && container.peek() == '{') container.pop();
            else if (c == ']' && !container.isEmpty() && container.peek() == '[') container.pop();
            else return false;
        }
        return (container.size() == 0);
    }
}