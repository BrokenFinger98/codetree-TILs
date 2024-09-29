import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        dp = new int[n][n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j][2] = -1;
            }
        }

        System.out.println(go(n-1, n-1));
        br.close();
    }
    static int go(int y, int x){
        if(y == 0 && x == 0){
            dp[y][x][0] = map[y][x];
            dp[y][x][1] = map[y][x];
            return map[y][x];
        }
        if(dp[y][x][2] == -1){
            int minUp;
            int maxUp;
            int minLeft;
            int maxLeft;
            if(y > 0) {
                go(y-1, x);
                minUp = Math.min(map[y][x], dp[y - 1][x][0]);
                maxUp = Math.max(map[y][x], dp[y - 1][x][1]);
            }else{
                minUp = 1;
                maxUp = 100;
            }
            if(x > 0) {
                go(y, x-1);
                minLeft = Math.min(map[y][x], dp[y][x-1][0]);
                maxLeft = Math.max(map[y][x], dp[y][x-1][1]);
            }else{
                minLeft = 1;
                maxLeft = 100;
            }
            int a = Math.abs(minUp- maxUp);
            int b = Math.abs(minLeft - maxLeft);
            if(a < b){
                dp[y][x][0] = minUp;
                dp[y][x][1] = maxUp;
                dp[y][x][2] = a;
            }else{
                dp[y][x][0] = minLeft;
                dp[y][x][1] = maxLeft;
                dp[y][x][2] = b;
            }
        }
        return dp[y][x][2];
    }
}