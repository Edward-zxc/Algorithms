public class RodCutting {

    public static int memizedCutRod(int[] p, int n) {
        // 初始化备忘录数组
        int[] r = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            r[i] = Integer.MIN_VALUE;
        }
        return memizedCutRodAux(p, n, r);
    }

    private static int memizedCutRodAux(int[] p, int n, int[] r) {
        // 自顶向下带备忘录的递归实现
        if (r[n] >= 0) {
            return r[n];
        }
        int q;
        if (n == 0) {
            q = 0;
        } else {
            q = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                q = Math.max(q, p[i] + memizedCutRodAux(p, n - i, r));
            }
        }
        r[n] = q;
        return q; // 返回最优解
    }

    public static int bottomUpCutRod(int[] p, int n) {
        // 自底向上的动态规划实现
        int[] r = new int[n + 1];
        r[0] = 0; // 长度为0的钢条没有收益

        for (int j = 1; j <= n; j++) {
            int q = Integer.MIN_VALUE;
            for (int i = 1; i <= j; i++) {
                q = Math.max(q, p[i] + r[j - i]);
            }
            r[j] = q; // 保存子问题的最优解
        }

        return r[n]; // 返回最优解
    }

    public static void main(String[] args) {
        int[] p = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        int n = 10;

        // 使用自顶向下带备忘录的解法
        int maxMemoized = memizedCutRod(p, n);
        System.out.println("最大收益（自顶向下）: " + maxMemoized);

        // 使用自底向上的解法
        int maxBottomUp = bottomUpCutRod(p, n);
        System.out.println("最大收益（自底向上）: " + maxBottomUp);
    }
}
