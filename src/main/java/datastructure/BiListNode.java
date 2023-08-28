package datastructure;

/**
 * @author LongyunBian
 * @version  2023/8/18 22:54
 */
public class BiListNode {
    public int key;
    public int val;
    public int freq;
    public BiListNode next;
    public BiListNode prev;

    public BiListNode(int key, int val, int freq) {
        this.key = key;
        this.val = val;
        this.freq = freq;
    }

    public BiListNode(int key, int val){
        this.key = key;
        this.val = val;
    }

    public BiListNode() {

    }
}
