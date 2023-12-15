package algorithm.array.divide;

/**
 * @author LongyunBian
 * @version 2023/11/22 23:08
 */
public class 冒泡排序 {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int j = 0; j < n - 1; j++) {
            for (int k = 0; k < n - 1 - j; k++) {
                if (arr[k] > arr[k + 1]) {
                    // Swap elements
                    int temp = arr[k];
                    arr[k] = arr[k + 1];
                    arr[k + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 1, 5, 7, 3};
        long startTime = System.nanoTime();
        for (int i = 0; i < 100000000; i++) {
            bubbleSort(nums);
        }

        long elapsedTime = System.nanoTime() - startTime;
        double elapsedTimeInSeconds = elapsedTime / 1e6; // 转换为秒

        System.out.println(elapsedTimeInSeconds + " ms");
    }
}
