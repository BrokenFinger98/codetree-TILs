import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 */
public class Main {
    static int n, answer;
    static int[] dp;
    static int[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        dp = new int[n];
        num = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            dp[i] = -1;
        }
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(dp[j] == -1) continue;
                if(j + num[j] >= i)
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
        br.close();
    }
}