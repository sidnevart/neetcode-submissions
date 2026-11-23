class TimeMap {
    static class TimeMapRecord {
        private int timestamp;
        private String val;
        public TimeMapRecord(int timestamp, String val){
            this.val = val;
            this.timestamp = timestamp;
        }
    }

    Map<String, List<TimeMapRecord>> records;
    public TimeMap() {
        records = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        records.computeIfAbsent(key, k -> new ArrayList<>()).add(new TimeMapRecord(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<TimeMapRecord> keyRecords = records.get(key);
        if (keyRecords == null){
            return "";
        }
        keyRecords.sort((a, b) -> Integer.compare(a.timestamp, b.timestamp));
        int l = 0;
        int r = keyRecords.size() - 1;
        while (l <= r){
            int m = l + (r - l) / 2;
            if (keyRecords.get(m).timestamp == timestamp){
                return keyRecords.get(m).val;
            } else if (keyRecords.get(m).timestamp > timestamp){
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return r >= 0 ? keyRecords.get(r).val : "";

    }
}
