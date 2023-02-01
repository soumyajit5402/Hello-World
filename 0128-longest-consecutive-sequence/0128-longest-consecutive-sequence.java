class Solution {
    public int longestConsecutive(int[] nums) {
        int lenMax = 0;
        Map<Integer, int[]> container = new HashMap<>();
        for (int num : nums) {
            if (container.containsKey(num)) continue;
            
            int[] val = new int[] { num, num };
            if (container.containsKey(num - 1)) val[0] = container.get(num - 1)[0];
            if (container.containsKey(num + 1)) val[1] = container.get(num + 1)[1];
            
            if (container.containsKey(num - 1)) container.get(val[0])[1] = val[1];
            if (container.containsKey(num + 1)) container.get(val[1])[0] = val[0];
            lenMax = Math.max(lenMax, (val[1] - val[0] + 1));
            container.put(num, val);
        }
        return lenMax;
    }
}