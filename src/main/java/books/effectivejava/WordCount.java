package books.effectivejava;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LongyunBian
 * @version 2023/9/26 9:21
 */
public class WordCount {
    public static void main(String[] args) {
        Map<String, Integer> wordCountMap = new HashMap<>();
        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry", "banana");

        for (String word : words) {
            wordCountMap.merge(word, 1, Integer::sum);
        }

        // 打印每个单词出现的次数
        for (String word : wordCountMap.keySet()) {
            System.out.println(word + ": " + wordCountMap.get(word));
        }
    }
}
