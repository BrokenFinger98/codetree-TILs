import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Line implements Comparable<Line>{
        int x1, x2;

        public Line(int x1, int x2) {
            this.x1 = x1;
            this.x2 = x2;
        }

        @Override
        public int compareTo(Line o) {
            if(this.x1 == o.x1) return Integer.compare(this.x2, o.x2);
            return Integer.compare(this.x1, o.x1);
        }
    }
    static int n, end, answer;
    static List<Line> lines = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            lines.add(new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(lines);
        end = lines.get(0).x2;
        answer = 1;
        for (int i = 1; i < n; i++) {
            Line line = lines.get(i);
            if(line.x1 > end){
                end = line.x2;
                ++answer;
            }
        }
        System.out.println(answer);
        br.close();
    }
}