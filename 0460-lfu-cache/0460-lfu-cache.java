class LFUCache {
    int size = 0;
    int capacity = 0;
    Map<Integer, Integer> counter = new HashMap<>();
    Map<Integer, Integer> container = new HashMap<>();
    TreeMap<Integer, LinkedHashSet<Integer>> lfu_lru_cont = new TreeMap<>();
    public LFUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (container.containsKey(key)) {
            int oldCounter = counter.get(key);
            int newCounter = oldCounter + 1;
            
            lfu_lru_cont.putIfAbsent(newCounter, new LinkedHashSet<>());
            lfu_lru_cont.get(newCounter).add(key);
            
            lfu_lru_cont.get(oldCounter).remove(key);
            if (lfu_lru_cont.get(oldCounter).size() == 0) {
                lfu_lru_cont.remove(oldCounter);
            }
            
            counter.put(key, newCounter);
            return container.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;
        Map<Integer, Integer> counterCopy = counter;
        Map<Integer, Integer> containerCopy = container;
        TreeMap<Integer, LinkedHashSet<Integer>> lfu_lru_cont_Copy = lfu_lru_cont;
        
        if (container.containsKey(key)) {
            lfu_lru_cont.putIfAbsent(counter.get(key) + 1, new LinkedHashSet<>());
            lfu_lru_cont.get(counter.get(key) + 1).add(key);
            lfu_lru_cont.get(counter.get(key)).remove(key);
            if (lfu_lru_cont.get(counter.get(key)).size() == 0) {
                lfu_lru_cont.remove(counter.get(key));
            }
        } else {
            if (size < capacity) {
                lfu_lru_cont.putIfAbsent(1, new LinkedHashSet<>());
                lfu_lru_cont.get(1).add(key);
                size++;
            } else {
                int leastFrequency = lfu_lru_cont.ceilingKey(0);
                LinkedHashSet<Integer> leastFrequentKeys = lfu_lru_cont.get(leastFrequency);
                Iterator<Integer> itr = leastFrequentKeys.iterator();
                int leastFrequentLeastRecentKey = itr.next();

                lfu_lru_cont.get(leastFrequency).remove(leastFrequentLeastRecentKey);
                if (lfu_lru_cont.get(leastFrequency).size() == 0) {
                    lfu_lru_cont.remove(leastFrequency);
                }
                container.remove(leastFrequentLeastRecentKey);
                counter.remove(leastFrequentLeastRecentKey);
                lfu_lru_cont.putIfAbsent(1, new LinkedHashSet<>());
                lfu_lru_cont.get(1).add(key);
            }
        }
        counter.put(key, counter.getOrDefault(key, 0) + 1);
        container.put(key, value);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */