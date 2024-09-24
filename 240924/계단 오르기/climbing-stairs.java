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
        System.out.println(up(N));
        br.close();
    }
    static int up(int n){
        if(n == 2 || n == 3) return dp[n] = 1;
        if(dp[n] == 0) dp[n] = up(n-2) + up(n-3);
        return dp[n];
    }
}