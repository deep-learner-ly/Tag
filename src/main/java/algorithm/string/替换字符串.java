package algorithm.string;

import utils.Utils;

/**
 * @author LongyunBian
 * @version 2023/9/1 22:40
 */
public class 替换字符串 {
    public static void main(String[] args) {
        String a = "abcbcabcbca";
        String b = "bc";
        String c = "XYZ";

        String result = replaceAllOccurrences(a, b, c);
        System.out.println(result); // 输出结果：aXYZXYZaXYZXYZa
    }
    public static String replaceAllOccurrences(String input, String target, String replacement) {
        StringBuilder result = new StringBuilder();
        int lastIndex = 0;
        int index;

        while ((index = Utils.strStr(input,target,lastIndex)) != -1) {
            result.append(input, lastIndex, index); // 将前面部分添加到结果中
            result.append(replacement); // 添加替换字符串
            lastIndex = index + target.length(); // 更新搜索的起始位置
        }

        result.append(input, lastIndex, input.length()); // 添加剩余部分
        return result.toString();
    }
}
