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
        dp =  new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;
        go(n-1, m-1);
        System.out.println(answer);
        br.close();
    }
    static int go(int y, int x){
        if(y == 0 && x == 0) return dp[0][0];
        if(dp[y][x] != 0) return dp[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if(num[i][j] < num[y][x])
                    dp[y][x] = Math.max(dp[y][x], go(i, j) + 1);
            }
        }
        answer = Math.max(answer, dp[y][x]);
        return dp[y][x];
    }
}