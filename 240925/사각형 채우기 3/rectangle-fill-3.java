import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 *  시간 : 80ms, 메모리 : 11,928KB
 */
public class Main {
    static int n;
    static final int MOD = 1_000_000_007;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        if(n == 1) {
            System.out.println(2);
            System.exit(0);
        }
        dp = new int[n+1][2];
        dp[1][1] = 2;
        dp[2][1] = 7;
        dp[2][0] = 1;
        for(int i = 3; i <= n; ++i){
            dp[i][0] = (dp[i-3][1] + dp[i-1][0])%MOD;
            dp[i][1] = (dp[i-1][1]*2 + dp[i-2][1] * 3 + dp[i][0] * 2)%MOD;
        }
        System.out.println(dp[n][1]);
    }
}