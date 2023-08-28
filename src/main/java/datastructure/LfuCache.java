package datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LongyunBian
 * @version 2023/8/21 12:04
 * @link https://leetcode.cn/problems/lfu-cache/description/
 */
public class LfuCache {
    // todo
    int minFreq, capacity;
    Map<Integer, BiListNode> keyTable;
    Map<Integer, DoublyLinkedList> freqTable;
    public LfuCache(int capacity) {
        this.minFreq = 0;
        this.capacity = capacity;
        keyTable = new HashMap<Integer, BiListNode>();
        freqTable = new HashMap<Integer, DoublyLinkedList>();
    }

    public int get(int key) {
        if (capacity == 0) {
            return -1;
        }
        if (!keyTable.containsKey(key)) {
            return -1;
        }
        BiListNode node = keyTable.get(key);
        int val = node.val, freq = node.freq;
        freqTable.get(freq).remove(node);
        // 如果当前链表为空，我们需要在哈希表中删除，且更新minFreq
        if (freqTable.get(freq).size == 0) {
            freqTable.remove(freq);
            if (minFreq == freq) {
                minFreq += 1;
            }
        }
        // 插入到 freq + 1 中
        DoublyLinkedList list = freqTable.getOrDefault(freq + 1, new DoublyLinkedList());
        list.addFirst(new BiListNode(key, val, freq + 1));
        freqTable.put(freq + 1, list);
        keyTable.put(key, freqTable.get(freq + 1).getHead());
        return val;
    }





}
