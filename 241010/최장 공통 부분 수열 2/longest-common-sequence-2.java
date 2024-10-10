import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static class Pair{
        int y, x;
        char c;
        public Pair(int y, int x, char c) {
            this.y = y;
            this.x = x;
            this.c = c;
        }
    }
    static String s1, s2;
    static int[][] dp;
    static int answer;
    static Pair last;
    static List<Pair> path = new ArrayList<>();
    static ArrayDeque<Character> stack = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        s1 = br.readLine();
        s2 = br.readLine();
        dp = new int[s1.length()][s2.length()];
        dp[0][0] = s1.charAt(0) == s2.charAt(0) ? 1 : 0;
        for (int i = 1; i < s1.length(); i++) {
            if(s1.charAt(i) == s2.charAt(0)){
                dp[i][0] = 1;
            }else{
                dp[i][0] = dp[i-1][0];
            }
        }
        for (int i = 1; i < s2.length(); i++) {
            if(s2.charAt(i) == s1.charAt(0)){
                dp[0][i] = 1;
            }else{
                dp[0][i] = dp[0][i-1];
            }
        }
        for (int i = 1; i < s1.length(); i++) {
            for (int j = 1; j < s2.length(); j++) {
                if(s1.charAt(i) == s2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        answer = dp[s1.length()-1][s2.length()-1];
        for (int i = s2.length() - 2; i >= 0; i--) {
            if(dp[s1.length()-1][i] < dp[s1.length()-1][i+1]){
                stack.push(s2.charAt(i));
            }
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.append(s2.charAt(s2.length()-1));
        System.out.println(sb);
        br.close();
    }
}