class Solution {
    public int maximumPopulation(int[][] logs) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] log : logs) {
            map.put(log[0], map.getOrDefault(log[0], 0) + 1); // add 1 to poplation in start year
            map.put(log[1], map.getOrDefault(log[1], 0) - 1); // subtract 1 from population in end year
        }
        
        int ans = 2050, maxVal = 0, population = 0;
        for (int year = 1950; year < 2050; year++) {
            population += map.getOrDefault(year, 0);
            if (population > maxVal) {
                ans = year;
                maxVal = population;
            }
        }
        return ans;
    }
}