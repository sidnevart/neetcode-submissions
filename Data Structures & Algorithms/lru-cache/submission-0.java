class LRUCache {
    static class Node {
        int val;
        Node prev;
        Node next;
        int key;
        public Node(){
            this.next = null;
            this.prev = null;
        }
        public Node(int val, int key){
            this.val = val;
            this.key = key;
            this.next = null;
            this.prev = null;

        }
        public Node(int val, int key, Node prev, Node next){
            this.val = val;
            this.key = key;
            this.prev = prev;
            this.next = next;
        }
    }
    Map<Integer, Node> cache;
    int capacity;
    Node start;
    Node tail;
    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
        start = new Node();
        tail = new Node();
        tail.prev = start;
        start.next = tail;
    }
    
    public int get(int key) {
        // add node to the end
        if (!cache.containsKey(key)){
            return -1;
        }
        Node node = cache.get(key);
        removeNode(node);
        addNodeToEnd(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.val = value;

            removeNode(node);
            addNodeToEnd(node);
            return;
        }

        if (capacity == cache.size()) {
            int removedKey = removeNodeFromStart();
            cache.remove(removedKey);
        }
        Node newNode = new Node(value, key);
        cache.put(key, newNode);
        addNodeToEnd(newNode);
    }
    
    /*
        returns key to remove from cache 
    */
    public int removeNodeFromStart(){
        Node node = start.next;
        int key = node.key;
        start.next = node.next;
        node.next.prev = start;
        node.next = null;
        node.prev = null;

        return key;
    }

    public void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addNodeToEnd(Node node){
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }
}
