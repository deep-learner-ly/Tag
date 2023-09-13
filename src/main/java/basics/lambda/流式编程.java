package basics.lambda;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author LongyunBian
 * @version 2023/9/12 11:35
 */
public class 流式编程 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        names.stream()
                .filter(name -> name.length() > 3)
                .forEach(System.out::println);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 过滤出偶数
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        // 输出 [2, 4, 6, 8, 10]
        System.out.println(evenNumbers);

        // 将名字转换为大写
        List<String> upperCaseNames = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        // 输出 ["ALICE", "BOB", "CHARLIE"]
        System.out.println(upperCaseNames);


        // 求和
        int sum = numbers.stream()
                .reduce(0, (a, b) -> a + b);

        // 输出 55
        System.out.println(sum);

        // 按字母顺序排序
        List<String> sortedNames = names.stream()
                .sorted()
                .collect(Collectors.toList());

        // 输出 ["Alice", "Bob", "Charlie"]
        System.out.println(sortedNames);

        // 去重
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        // 输出 [1, 2, 3, 4, 5]
        System.out.println(distinctNumbers);

        // 计数
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");

        boolean anyStartsWithA =
                stringCollection
                        .stream()
                        .anyMatch((s) -> s.startsWith("a"));

        System.out.println(anyStartsWithA);      // true

        boolean allStartsWithA =
                stringCollection
                        .stream()
                        .allMatch((s) -> s.startsWith("a"));

        System.out.println(allStartsWithA);      // false

        boolean noneStartsWithZ =
                stringCollection
                        .stream()
                        .noneMatch((s) -> s.startsWith("z"));

        System.out.println(noneStartsWithZ);      // true

        long startsWithB =
                stringCollection
                        .stream()
                        .filter((s) -> s.startsWith("b"))
                        .count();

        System.out.println(startsWithB);    // 3

        Optional<String> reduced =
                stringCollection
                        .stream()
                        .sorted()
                        .reduce((s1, s2) -> s1 + "#" + s2);
        System.out.println();
        System.out.println(reduced.get());

    }
}
