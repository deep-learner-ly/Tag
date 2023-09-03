package algorithm.dp.dp1;

import java.util.Scanner;

/**
 * @author LongyunBian
 * @version 2023/9/1 21:00
 */
public class XnYn {
    /*
    * 已知 x+y = A, xy = B
    * 求x^n +y^n
    * 递推式：xn = Axn-1 - Bxn-2
    * */
    private static int mod = (int) (1e9 + 7);
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            long res = compute(a,b,n);
            System.out.println(res);
        }
    }

    private static long compute(int a, int b, int n) {
        if(n==1) return a;
        if(n==2) return (long)a*a - 2L *b;
        long [] dp = new long[n];
        dp[0] = a;
        dp[1] = compute(a,b,2);
        for (int i = 2; i < n; i++) {
            //所有的运算都在模1e9+7下进行.
            dp[i] =a*dp[i-1]%mod - b * dp[i-2]%mod;
        }
        return dp[n-1];

    }
    private static long computeO1(int a, int b, int n) {
        if (n == 1) return a;
        if (n == 2) return (long)a * a - 2L * b;
        long dp0 = a;
        long dp1 = compute(a, b, 2);
        for (int i = 2; i < n; i++) {
            long newDp1 = ((a * dp1 % mod - b * dp0 % mod)+mod)%mod;
            dp0 = dp1;
            dp1= newDp1;
        }
        return dp1;

    }
}
