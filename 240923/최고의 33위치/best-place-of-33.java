import java.io.*;
import java.lang.*;
import java.util.*;
public class Main {
    static int[][] map;
    static int N, answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for(int i = 0; i < N; ++i){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; ++j){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(i >= 2 && j >= 2){
                    int sum = 0;
                    for(int k = i-2; k < 3; ++k){
                        for(int l = j-2; l < 3; ++l){
                            if(map[k][l] == 1) ++sum;
                        }
                    }
                    answer = Math.max(answer, sum);
                }
            }
        }
        System.out.println(answer);
    }
}