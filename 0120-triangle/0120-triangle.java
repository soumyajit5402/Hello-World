class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) return triangle.get(0).get(0);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j <= i; j++) {
                int currVal = triangle.get(i).get(j);
                int prevVal = (j < i) ? triangle.get(i - 1).get(j) : Integer.MAX_VALUE;
                if (j > 0) prevVal = Math.min(prevVal, triangle.get(i - 1).get(j - 1));
                triangle.get(i).set(j, currVal + prevVal);
                if (i == triangle.size() - 1) min = Math.min(min, triangle.get(i).get(j));
            }
        }
        return min;
    }
}