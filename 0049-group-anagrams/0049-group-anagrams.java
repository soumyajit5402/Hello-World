class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> container = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String sortedAnagram = new String(arr);
            container.putIfAbsent(sortedAnagram, new ArrayList<>());
            container.get(sortedAnagram).add(strs[i]);
        }
        
        List<List<String>> ans = new ArrayList<>();
        for (List<String> val : container.values()) ans.add(val);
        return ans;
    }
}