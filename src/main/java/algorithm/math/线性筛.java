package algorithm.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author LongyunBian
 * @version 2023/9/26 17:31
 */
public class 线性筛 {
    public int countPrimes(int n) {
        List<Integer> primes = new ArrayList<Integer>();
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                primes.add(i);
            }
            for (int j = 0; j < primes.size() && i * primes.get(j) < n; ++j) {
                isPrime[i * primes.get(j)] = 0;
                if (i % primes.get(j) == 0) {
                    break;
                }
            }
        }
        return primes.size();

    }

    public static void main(String[] args) {
        System.out.println(new 线性筛().countPrimes(100));
    }
}
