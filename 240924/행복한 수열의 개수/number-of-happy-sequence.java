import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int n, m, answer;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            int num = 0;
            int count = 1;
            int sum = 0;
            for (int j = 0; j < n-1; j++) {
                if (map[i][j] == map[i][j + 1]) {
                    num = map[i][j];
                    ++count;
                } else {
                    if (count >= m) {
                        sum = Math.max(count, sum);
                    }
                    count = 1;
                }
            }
            if(count >= m) {
                sum = Math.max(count, sum);
            }
            if(sum >= m)
                answer++;
        }

        for (int i = 0; i < n; i++) {
            int num = 0;
            int count = 1;
            int sum = 0;
            for (int j = 0; j < n-1; j++) {
                if(map[j][i] == map[j+1][i]){
                    num = map[j][i];
                    ++count;
                }else{
                    if(count >= m) {
                        sum = Math.max(count, sum);
                    }
                    count = 1;
                }
            }
            if(count >= m) {
                sum = Math.max(count, sum);
            }
            if(sum >= m)
                answer++;
        }
        System.out.println(answer);
        br.close();
    }
}