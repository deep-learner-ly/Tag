package algorithm.simulation;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author LongyunBian
 * @version 2023/9/7 15:15
 */
public class 字符重排 {
//    当且仅当该字符串相邻的字符不相等。例如"arcaea"是好串，而"food"不是好串。
//    一个字符串，她可以将该字符串的各个字符顺序随意打乱。她想知道一共可以生产多少种不同的好串？
    static int res;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        char [] chars = str.toCharArray();
        Arrays.sort(chars);
        boolean  [] visited = new boolean[str.length()];
        res = 0;
        backtrack(visited,chars,new LinkedList<Character>() );
        System.out.println(res);
    }

    private static void backtrack( boolean[] visited,  char [] chars, LinkedList<Character> path) {
        if(path.size()>chars.length){
            return;
        }
        if(path.size()==chars.length){
            res++;
        }
        for (int i = 0; i < chars.length; i++) {
            if(visited[i]) continue;
            if(!path.isEmpty()&&path.peek()==chars[i]) continue;
            if(i>0&&chars[i]==chars[i-1]&&!visited[i-1]) continue;
            visited[i] = true;
            path.push(chars[i]);
            backtrack(visited,chars,path);
            path.pop();
            visited[i] = false;
        }

    }
}
