package algorithm.bfs;

import java.util.*;

/**
 * @author LongyunBian
 * @version 2023/9/21 16:13
 */
public class 公交路线 {
    int s, t;
    int[][] rs;
    public int numBusesToDestination(int[][] _rs, int _s, int _t) {
        rs = _rs; s = _s; t = _t;
        if (s == t) return 0;
        int ans = bfs();
        return ans;
    }
    int bfs() {
        // 记录某个车站可以进入的路线
        Map<Integer, Set<Integer>> map = new HashMap<>();
        // 队列存的是经过的路线
        Deque<Integer> d = new ArrayDeque<>();
        // 哈希表记录的进入该路线所使用的距离
        Map<Integer, Integer> m = new HashMap<>();
        int n = rs.length;
        for (int i = 0; i < n; i++) {
            for (int station : rs[i]) {
                // 将从起点可以进入的路线加入队列
                if (station == s) {
                    d.addLast(i);
                    m.put(i, 1);
                }
                Set<Integer> set = map.getOrDefault(station, new HashSet<>());
                set.add(i);
                map.put(station, set);
            }
        }
        while (!d.isEmpty()) {
            // 取出当前所在的路线，与进入该路线所花费的距离
            int poll = d.pollFirst();
            int step = m.get(poll);

            // 遍历该路线所包含的车站
            for (int station : rs[poll]) {
                // 如果包含终点，返回进入该路线花费的距离即可
                if (station == t) return step;

                // 将由该线路的车站发起的路线，加入队列
                Set<Integer> lines = map.get(station);
                if (lines == null) continue;
                for (int nr : lines) {
                    if (!m.containsKey(nr)) {
                        m.put(nr, step + 1);
                        d.add(nr);
                    }
                }
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        int [][] routes = {{0,1,6,16,22,23},{14,15,24,32},{4,10,12,20,24,28,33},{1,10,11,19,27,33},{11,23,25,28},{15,20,21,23,29},{29}};
        System.out.println(new 公交路线().numBusesToDestination(routes, 21, 4));
    }
}
