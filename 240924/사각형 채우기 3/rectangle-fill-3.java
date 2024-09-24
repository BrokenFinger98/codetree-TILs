import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        System.out.println(go(N));
        br.close();
    }

    static int go(int n) {
        if (n == 0) return dp[n] = 1;
        if (n == 1) return dp[n] = 2;
        if (n == 2) return dp[n] = 7;
        if (dp[n] == 0) dp[n] = (go(n - 1) * 2 + go(n - 2) * 3 + go(n - 3) * 2) % 1000000007;
        return dp[n];
    }
}