import java.util.Scanner;

public class BellNumber {

    // 计算组合数 C(n, k)
    private static long comb(int n, int k) {
        if (k > n) return 0;
        long result = 1;
        for (int i = 1; i <= k; ++i) {
            result *= (n - (k - i));
            result /= i;
        }
        return result;
    }

    // 计算Bell数
    private static long bellNumber(int n) {
        // 创建二维数组存储Bell数
        long[][] bell = new long[n + 1][n + 1];

        // 初始条件
        bell[0][0] = 1;  // B(0) = 1

        // 使用递推公式计算Bell数
        for (int i = 1; i <= n; ++i) {
            bell[i][0] = bell[i - 1][i - 1]; // Bell数的第一列是上一行的对角线元素
            for (int j = 1; j <= i; ++j) {
                bell[i][j] = bell[i - 1][j - 1] + bell[i][j - 1];
            }
        }

        return bell[n][0];  // Bell数的第n个元素是第n行的第0列
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入n的值：");
        int n = scanner.nextInt();

        // 计算并输出集合的划分数
        System.out.println("集合{1, 2, ..., " + n + "}可以划分为" + bellNumber(n) + "个不同的非空子集。");
    }
}
