import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int now;
        int depth;

        public Node(int now, int depth) {
            this.now = now;
            this.depth = depth;
        }
    }

    static int a, b;
    static int[] visited;
    static Queue<Node> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        visited = new int[b * 2 + 1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[a] = 0;
        queue.offer(new Node(a, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int now = node.now;
            int depth = node.depth;
            if(now == b) break;
            if (now > 0 && visited[now - 1] > depth) {
                visited[now - 1] = depth + 1;
                queue.offer(new Node(now - 1, depth + 1));
            }
            if (now < b && visited[now + 1] > depth) {
                visited[now + 1] = depth + 1;
                queue.offer(new Node(now + 1, depth + 1));
            }
            if (now * 2 < b * 2 + 1&& now * 2 - b <= b - now && visited[now * 2] > depth) {
                visited[now * 2] = depth;
                queue.offer(new Node(now * 2, depth));
            }
        }

        System.out.println(visited[b]);
        br.close();
    }
}