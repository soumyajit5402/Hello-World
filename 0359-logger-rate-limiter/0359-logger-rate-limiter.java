class Logger {
    Map<String, Integer> container;
    public Logger() {
        container = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (container.getOrDefault(message, -1) <= timestamp) {
            container.put(message, timestamp + 10);
            return true;
        }
        return false;
    }
}