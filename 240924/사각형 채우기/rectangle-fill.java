import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        dp[1] = 1;
        dp[2] = 2;
        System.out.println(go(N));
        br.close();
    }
    static int go(int n){
        if(n <= 2) return dp[n];
        if(dp[n] == 0) dp[n] = (go(n-1) + go(n-2))%10007;
        return dp[n];
    }
}