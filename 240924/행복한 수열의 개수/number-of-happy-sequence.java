import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
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
                        ++sum;
                    }
                    count = 1;
                }
            }
            if(count >= m) {
                ++sum;
            }
            answer += sum;
        }

        for (int i = 0; i < n-1; i++) {
            int num = 0;
            int count = 1;
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if(map[j][i] == map[j][i+1]){
                    num = map[j][i];
                    ++count;
                }else{
                    if(count >= m) {
                        ++sum;
                    }
                    count = 1;
                }
            }
            if(count >= m) {
                ++sum;
            }
            answer += sum;
        }
        System.out.println(answer);
        br.close();
    }
}