import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, max = 1, answer = Integer.MAX_VALUE;
    static int[][] map;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
            }
        }

        dp = new int[n][n][max+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }
        dp[0][0][map[0][0]] = map[0][0];
        for (int i = 1; i < n; i++) {
            for (int k = 1; k <= max; k++) {
                dp[i][0][Math.min(k, map[i][0])] = Math.min(dp[i][0][Math.min(k, map[i][0])], Math.max(dp[i-1][0][k], map[i][0]));
                dp[0][i][Math.min(k, map[0][i])] = Math.min(dp[0][i][Math.min(k, map[0][i])], Math.max(dp[0][i-1][k], map[0][i]));
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                for (int k = 1; k <= max; k++) {
                    dp[i][j][Math.min(k, map[i][j])] = Math.min(dp[i][j][Math.min(k, map[i][j])], Math.max(Math.min(dp[i-1][j][k], dp[i][j-1][k]), map[i][j]));
                }
            }
        }

        for (int i = 1; i <= max; i++) {
            if(dp[n-1][n-1][i] != Integer.MAX_VALUE){
                answer = Math.min(answer, dp[n-1][n-1][i]-i);
            }
        }
        System.out.println(answer);
        br.close();
    }
}