package books.effectivejava;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author LongyunBian
 * @version 2023/9/26 9:38
 */
public class FunctionDemo {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("1", "2", "3", "4", "5");
        Function<String, Integer> stringToInteger = Integer::parseInt;

        List<Integer> integerList = stringList.stream()
                .map(stringToInteger)
                .collect(Collectors.toList());

        System.out.println("Integer List: " + integerList);
    }
}
