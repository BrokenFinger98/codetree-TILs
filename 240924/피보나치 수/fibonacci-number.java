import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        System.out.println(fibo(N));
        br.close();
    }
    static int fibo(int n){
        if(n <= 2) return dp[n] = 1;
        if(dp[n] == 0) dp[n] = fibo(n-1) + fibo(n-2);
        return dp[n];
    }
}