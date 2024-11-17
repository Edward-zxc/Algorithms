import java.util.Scanner;

public class TournamentScheduler {

    // schedule 方法，用于生成比赛日程表
    public static void schedule(int[][] table, int n, int k) {
        // 初始化第一行
        for (int i = 1; i <= n; i++) {
            table[1][i] = i;
        }

        int m = 1;
        for (int s = 1; s <= k; s++) {
            n /= 2;
            for (int t = 1; t <= n; t++) {  // 对每一部分进行划分（达到分治目的）
                for (int i = 1 + m; i <= 2 * m; i++) { // 控制行
                    for (int j = 1 + m; j <= 2 * m; j++) {   // 控制列
                        table[i][j + (t - 1) * m * 2] = table[i - m][j + (t - 1) * m * 2 - m];  // 右下角等于左上角的值
                        table[i][j + (t - 1) * m * 2 - m] = table[i - m][j + (t - 1) * m * 2];  // 左下角等于右上角的值
                    }
                }
            }
            m *= 2;
        }
    }

    // input 方法计算 k
    public static int input(int n, int k) {
        do {
            n = n / 2;
            k++;
        } while (n > 1);
        return k;
    }

    // display 方法用于输出比赛日程表
    public static void display(int[][] table, int n) {
        System.out.println("比赛日程表：");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(table[i][j]);
                if (j < n) {
                    System.out.print(" "); // 在列之间加上空格
                }
            }
            System.out.println();
        }
    }

    // main 方法，用于接收输入并调用其他方法
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入要比赛的人数: ");
        int n = scanner.nextInt();

        // 创建一个二维数组表示日程表
        int[][] table = new int[n + 1][n + 1];

        // 计算出2的k次方
        int k = 0;
        k = input(n, k);

        // 调用schedule生成比赛日程表
        schedule(table, n, k);

        // 输出比赛日程表
        display(table, n);
    }
}
