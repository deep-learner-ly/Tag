package algorithm.bisearch;

import java.util.Scanner;

/**
 * @author LongyunBian
 * @version 2023/9/15 23:10
 */
public class 路灯安装 {
    // x1,x2,...,xn这n个坐标可以安装照明灯，且每个坐标上最多只能安装一个照明灯。
    // 现在你要在道路上安装k个照明灯，为了使照明灯能够尽量覆盖道路，
    // 你需要使距离最近的两个照明灯尽量远。请问这个最近距离最大可以是多少?
    //输入描述
    //
    //第一行 是两个整数n、k，分别表示可以安装照明灯的位置数和需要安装的照明灯数量。
    //
    //接下来一行n个整数x1,x2,...,xn表示可以安装照明灯的坐标。保证x1<x2<...<xn。
    //
    //1<=k<=n<=100000,1<xi<1000000
    //
    //输出描述
    //
    //一行，一个整数，表示最近距离的最大值.
    //    样例输入
    //
    //5 3
    //        1 3 4 7 9
    //    样例输出
    //
    //3
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        int l = 0, r = 1000000000, ans = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            System.out.println(mid);
            if (check(n, k, mid,a)) {
                // 当前mid 作为距离是可以种k个的，但不一定是最大的距离
                ans = mid;
                // 让l变大可以，使后续的距离变大，在来看是否符合题意
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(ans);
    }

    public static boolean check(int n, int k, int dis,int [] a) {
        int cnt = 1, last = a[1];
        for (int i = 2; i <= n && cnt < k; i++) {
            if (a[i] >= last + dis) {
                cnt++;
                last = a[i];
            }
        }
        return cnt >= k;
    }

}
