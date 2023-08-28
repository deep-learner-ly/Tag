package datastructure;

/**
 * @author LongyunBian
 * @version 2023/8/20 23:05
 */
public class HashDict<K,V> {
    private final int n = 10009;
    private int size;
    private final Entry<K,V>[] table;
    private static class Entry<K,V> {
        K key;
        V value;
        Entry<K,V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    @SuppressWarnings("unchecked")
    public HashDict() {
        size = 0;
        this.table = (Entry<K, V>[]) new Entry[n];
    }

    private int hash(K key){
        return key.hashCode()%n;  // 最后使用取模运算得到最终哈希值

    }

    public void put(K key, V value) {
        int index = hash(key);

        if(table[index]==null){
            table[index] = new Entry<>(key,value);
            size++;
            return;
        }
        Entry<K,V> current = table[index];
        while (current != null) {
            if (current.key.equals(key) ) {
                current.value = value;
                return;
            }
            current = current.next;
        }
        Entry<K,V> head = table[index];
        Entry<K,V> entry = new Entry<>(key,value);
        table[index] = entry;
        entry.next = head;
        size++;

    }

    public V get(K key) {
        int index = hash(key);
        Entry<K,V> current = table[index];
        while (current!=null){
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;

    }

    public void remove(K key) {
        int index = hash(key);
        if(table[index]==null){
            return;
        }
        Entry<K,V> current = table[index];
        if(current.key == key){
            table[index] = current.next;
            size--;
            return;
        }
        while(current.next!=null){
            if(current.next.key==key){
                current.next = current.next.next;
                size--;
                return;
            }
            current = current.next;
        }

    }
    public int size(){
        return size;
    }

}
