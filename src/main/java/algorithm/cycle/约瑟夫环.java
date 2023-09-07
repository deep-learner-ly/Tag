package algorithm.cycle;

/**
 * @author LongyunBian
 * @version 2023/9/6 17:29
 */
public class 约瑟夫环 {
    /**
     * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，
     * 每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。
     * 求出这个圆圈里剩下的最后一个数字。
    */
    public int lastRemaining(int n, int m) {
        int res  = 0;
        for(int i= 2;i<=n;i++){
            res = (res+m)%i;
        }
        return res;
    }
    public int lastRemaining_recursion(int n, int m) {
        if(n==1)return 0;
        return (lastRemaining_recursion(n-1,m)+m)%n;

    }
    /**
    * 共有 n 名小伙伴一起做游戏。小伙伴们围成一圈，按 顺时针顺序 从 1 到 n 编号
    * */
    public int findTheWinner(int n, int k) {
        int winner = 1;
        for(int i=2;i<=n;i++){
            winner = (k + winner-1)%i +1;
        }
        return winner;
    }
    public int findTheWinner_recursion(int n, int k) {
        if(n==1) return 1;
        return (k + findTheWinner_recursion(n-1,k)-1)%n +1;

    }
}
