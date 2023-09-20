package algorithm.array;

import utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author LongyunBian
 * @version 2023/9/20 17:14
 */
public class 素数伴侣 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> odds = new ArrayList<>();
        List<Integer> evens = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int temp = in.nextInt();
            if((temp &1) ==0){
                evens.add(temp);
            }else {
                odds.add(temp);
            }
        }
        int [] evensMatch = new int[evens.size()];
        int result =0;
        for (int i = 0; i < odds.size(); i++) {
            int [] used = new int[evens.size()];
            if(find(odds.get(i), evens,used,evensMatch)) result++;
        }
        System.out.println(result);

    }

    private static boolean find(int x, List<Integer> evens, int[] used, int[] evensMatch) {
        for (int i = 0; i < evens.size(); i++) {
            if(Utils.isPrime(x+evens.get(i)) && used[i]==0){
                used[i] =1;
                if(evensMatch[i]==0 || find(evensMatch[i], evens,used,evensMatch)){
                    evensMatch[i] = x;
                    return true;
                }
            }
        }
        return false;
    }
}
