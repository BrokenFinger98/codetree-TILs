import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, answer = 0;
    static int[][] map;
    static int[][] dp;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer = Math.max(answer, dfs(i, j));
            }
        }

        System.out.println(answer);
        br.close();
    }

    private static int dfs(int y, int x) {
        int cnt = 0;
        if(dp[y][x] != 0) return dp[y][x];
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(!checkRange(ny, nx)) continue;
            if(map[y][x] < map[ny][nx]){
                cnt = Math.max(cnt, dfs(ny, nx));
            }
        }
        return dp[y][x] = cnt+1;
    }

    private static boolean checkRange(int y, int x) {
        if(y < 0 || y >= n || x < 0 || x >= n) return false;
        return true;
    }
}