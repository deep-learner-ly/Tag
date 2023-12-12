package algorithm.dfs.backtrack;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.*;

public class 电话号码的字母组合Test extends TestCase {

    @Test
    public void testLetterCombinations() {
        电话号码的字母组合 obj = new 电话号码的字母组合();
        List<String> result1 = obj.letterCombinations("23");
        assertEquals(Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"), result1);
        //帮我新建一个长度为3的list
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list);


    }

}