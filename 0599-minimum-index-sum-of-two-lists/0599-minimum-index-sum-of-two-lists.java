class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> container = new HashMap<>();
        List<String> ansList = new ArrayList<>();
        int minIndexSum = Integer.MAX_VALUE;
        
        for (int i = 0; i < list1.length; i++) container.put(list1[i], i);
        
        for (int i = 0; i < list2.length; i++) {
            if (container.containsKey(list2[i])) {
                int indexSum = container.get(list2[i]) + i;
                if (indexSum < minIndexSum) {
                    ansList.clear();
                    ansList.add(list2[i]);
                    minIndexSum = indexSum;
                } else if (indexSum == minIndexSum) {
                    ansList.add(list2[i]);
                }
            }
        }
        
        String[] ans = ansList.toArray(new String[0]);
        return ans;
    }
}