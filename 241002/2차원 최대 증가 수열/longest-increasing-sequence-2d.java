import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, answer;
    static int[][] num;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        num = new int[n][m];
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int y = 0; y < i; y++) {
                    for (int x = 0; x < j; x++) {
                        if (num[i][j] > num[y][x]) {
                            dp[i][j] = Math.max(dp[i][j], dp[y][x] + 1);
                        }
                    }
                }
                answer = Math.max(answer, dp[i][j]);
            }
        }

        System.out.println(answer);
        br.close();
    }
}