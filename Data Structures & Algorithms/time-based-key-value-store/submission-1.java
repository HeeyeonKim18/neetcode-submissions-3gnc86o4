class TimeMap {

    private Map<String, Map<Integer, String>> keyStore;

    public TimeMap() {
        keyStore = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!keyStore.containsKey(key)){
            keyStore.put(key, new HashMap<>());
        }
        keyStore.get(key).put(timestamp, value); 
    }
    
    public String get(String key, int timestamp) {
        if(!keyStore.containsKey(key)) return "";

        Map<Integer, String> timeMap = keyStore.get(key);

        int maxTime = -1;
        String res = "";

        for(int t : timeMap.keySet()){
            if(t <= timestamp && t > maxTime){
                maxTime = t;
                res = timeMap.get(t);
            }
        }
        return res;
    }
}
