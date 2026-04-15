class TimeMap {

    Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";

        List<Pair> list = map.get(key);

        int l = 0, r = list.size() - 1;
        String res = "";

        while(l <= r){
            int mid = l + (r - l) / 2;

            if(list.get(mid).timestamp <= timestamp){
                res = list.get(mid).value;
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return res;
    }

    static class Pair {
        String value;
        int timestamp;

        Pair(String v, int t){
            value = v;
            timestamp = t;
        }
    }
}
