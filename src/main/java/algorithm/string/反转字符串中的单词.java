package algorithm.string;

/**
 * @author LongyunBian
 * @version 2023/9/18 23:42
 */
public class 反转字符串中的单词 {
    public String reverseWords(String s) {
        int start, end;                       // 每个单词的开始和结束索引（左闭右开）
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') continue;   //跳过空格
            end = i + 1;                        //找到结束索引
            while (i >= 0 && s.charAt(i) != ' ') i--;   //跳过空格
            start = i + 1;                      //找到开始索引
            for (int j = start; j < end; j++)   //将每个单词按开始结束索引赋值到StringBuilder
                sb.append(s.charAt(j));
            sb.append(' ');                     //加上单词间的空格
        }
        sb.deleteCharAt(sb.length() - 1);       //删掉最后一个多余的空格
        return sb.toString();
    }
}
