import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dfs(0, 0, map[0][0], map[0][0]);

        System.out.println(dp[n - 1][n - 1]);
        br.close();
    }

    static void dfs(int y, int x, int min, int max) {
        min = Math.min(min, map[y][x]);
        max = Math.max(max, map[y][x]);
        int result = Math.abs(max - min);
        if (dp[y][x] < result) return;
        dp[y][x] = result;
        if (y + 1 < n)
            dfs(y + 1, x, min, max);
        if (x + 1 < n)
            dfs(y, x + 1, min, max);
    }
}