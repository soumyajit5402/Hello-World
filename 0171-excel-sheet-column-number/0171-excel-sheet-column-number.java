class Solution {
    public int titleToNumber(String columnTitle) {
        int column = 0;
        char[] charArr = columnTitle.toCharArray();
        
        for (int i = 0; i < charArr.length; i++) {
            column += (charArr[i] - 'A' + 1) * Math.pow(26, (charArr.length - i - 1));
        }
        return column;
    }
}