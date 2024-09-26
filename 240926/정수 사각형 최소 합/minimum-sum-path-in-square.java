import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        dp = new int[N+1][N+1];
        map = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[1][N-1] = map[1][N-1];
        for (int i = 1; i <= N; i++) {
            for (int j = N-1; j >= 0; j--) {
                int min = Math.min(dp[i][j+1], dp[i-1][j]);
                dp[i][j] = min == Integer.MAX_VALUE ?  map[i][j] : min + map[i][j];
            }
        }

        System.out.println(dp[N][0]);
        br.close();
    }
}