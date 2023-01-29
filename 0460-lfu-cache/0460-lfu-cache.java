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
            // derive counter for key
            int oldCounter = counter.get(key);
            int newCounter = oldCounter + 1;
            // assign and update container for new counter
            lfu_lru_cont.putIfAbsent(newCounter, new LinkedHashSet<>());
            lfu_lru_cont.get(newCounter).add(key);
            // remove old counter and prune container
            lfu_lru_cont.get(oldCounter).remove(key);
            pruneContainer(oldCounter);
            // update key to counter map
            counter.put(key, newCounter);
            // return value for key
            return container.get(key);
        }
        // return default
        return -1;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) {
            // no action needed
            return;
        } else if (container.containsKey(key)) {
            // derive counter for key
            int oldCounter = counter.get(key);
            int newCounter = oldCounter + 1;
            // assign and update container for new counter
            lfu_lru_cont.putIfAbsent(newCounter, new LinkedHashSet<>());
            lfu_lru_cont.get(newCounter).add(key);
            // remove old counter and prune container
            lfu_lru_cont.get(oldCounter).remove(key);
            pruneContainer(oldCounter);
        } else {
            if (size < capacity) {
                // assign and update container for new input
                lfu_lru_cont.putIfAbsent(1, new LinkedHashSet<>());
                lfu_lru_cont.get(1).add(key);
                // update the size of cache
                size++;
            } else {
                // derive least frequency in cache
                int leastFrequency = lfu_lru_cont.ceilingKey(0);
                // derive all least frquently used keys
                LinkedHashSet<Integer> leastFrequentKeys = lfu_lru_cont.get(leastFrequency);
                // derive the least recently used least frequent key
                Iterator<Integer> itr = leastFrequentKeys.iterator();
                int leastFrequentLeastRecentKey = itr.next();
                // remove least frequent least recent key and prune container
                lfu_lru_cont.get(leastFrequency).remove(leastFrequentLeastRecentKey);
                pruneContainer(leastFrequency);
                // remove least frequent least recent key from container and counter maps 
                container.remove(leastFrequentLeastRecentKey);
                counter.remove(leastFrequentLeastRecentKey);
                // assign and update container for new input
                lfu_lru_cont.putIfAbsent(1, new LinkedHashSet<>());
                lfu_lru_cont.get(1).add(key);
            }
        }
        // update the container and counter maps with new input
        counter.put(key, counter.getOrDefault(key, 0) + 1);
        container.put(key, value);
    }
    
    private void pruneContainer(int key) {
        if (lfu_lru_cont.containsKey(key) && lfu_lru_cont.get(key).size() == 0) {
            lfu_lru_cont.remove(key);
        }
    }
}