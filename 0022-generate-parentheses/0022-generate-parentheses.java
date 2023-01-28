class Solution {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generateCombinations(new StringBuilder(), n, n);
        return result;
    }
    
    private void generateCombinations(StringBuilder sb, int openCount, int closeCount) {
        if (openCount + closeCount == 0) {
            result.add(sb.toString());
            return;
        }
        
        if (openCount > 0) {
            StringBuilder sbNew = new StringBuilder(sb.toString()).append("(");
            generateCombinations(sbNew, openCount - 1, closeCount);
        }
        
        if (closeCount > 0 && openCount < closeCount) {
            StringBuilder sbNew = new StringBuilder(sb.toString()).append(")");
            generateCombinations(sbNew, openCount, closeCount - 1);
        }
    }
}