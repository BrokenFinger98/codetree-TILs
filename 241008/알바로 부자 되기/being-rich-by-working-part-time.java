import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Line implements Comparable<Line>{
        int x1, x2, value;

        public Line(int x1, int x2, int value) {
            this.x1 = x1;
            this.x2 = x2;
            this.value = value;
        }

        @Override
        public int compareTo(Line o) {
            return Integer.compare(this.x1, o.x1);
        }
    }
    static int n, answer;
    static List<Line> lines = new ArrayList<>();
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        dp = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            lines.add(new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(lines);
        for (int i = 0; i < n; i++) {
            dp[i] = lines.get(i).value;
            for (int j = 0; j < i; j++) {
                int x1I = lines.get(i).x1;
                int x2J = lines.get(j).x2;
                if(x2J < x1I)
                    dp[i] = Math.max(dp[i], dp[j] + lines.get(i).value);
            }
        }
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
        br.close();
    }
}