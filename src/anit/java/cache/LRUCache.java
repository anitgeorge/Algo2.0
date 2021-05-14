/**
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 * Implement the LRUCache class:
 *
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise,
 * add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation,
 * evict the least recently used key.
 *
 * https://leetcode.com/problems/lru-cache/
 */

class LRUCache {

    int cap;
    Map<Integer, Integer> cache;
    public LRUCache(int capacity) {

        cap = capacity;
        cache = new LinkedHashMap<Integer, Integer>();
    }

    public int get(int key) {

        if(!cache.containsKey(key))
            return -1;
        int value = cache.get(key);
        put(key, value);
        return value;
    }

    public void put(int key, int value) {

        if(cache.containsKey(key))
            cache.remove(key);
        if(cache.size() >= cap)
            cache.remove(cache.entrySet().iterator().next().getKey());
        cache.put(key, value);
    }

    public static void main(String[] args) {

        LRUCache lruCache = new LRUCache(5);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        for(int i = 3; i <= 6; i++)
            lruCache.put(i, i);
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(1));
    }
}