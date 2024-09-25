import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        dp = new int[n+1];
        System.out.println(go(n));
    }
    static int go(int num){
        if(num == 0) return dp[0] = 1;
        if(num == 1) return dp[1] = 1;
        if(num == 2) return dp[2] = 2;
        if(num == 3) return dp[3] = 5;
        if(dp[num] == 0) {
            for(int i = 0; i < num; ++i){
                dp[num] += go(num-i-1) * go(i);
            }
        }
        return dp[num];
    }
}