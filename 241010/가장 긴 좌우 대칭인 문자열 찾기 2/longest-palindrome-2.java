import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static char[] input;
    static int[] A;
    static int len;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        len = s.length();
        
        // 입력 문자열의 변환 (중간에 #을 끼워 넣는 작업)
        input = new char[len * 2 + 1];
        for (int i = 0; i < len; ++i) {
            input[i * 2] = '#';
            input[i * 2 + 1] = s.charAt(i);
        }
        input[len * 2] = '#';  // 마지막에 # 추가
        len = len * 2 + 1;     // 변환된 문자열의 길이
        
        A = new int[len];
        int r = -1;   // 오른쪽 경계
        int p = -1;   // 중심
        
        for (int i = 0; i < len; ++i) {
            if (r >= i) {
                A[i] = Math.min(r - i, A[2 * p - i]);  // 대칭성 이용
            } else {
                A[i] = 0;
            }
            
            // 팰린드롬 확장
            while (i - A[i] - 1 >= 0 && i + A[i] + 1 < len && input[i - A[i] - 1] == input[i + A[i] + 1]) {
                A[i]++;
            }
            
            // 새로운 경계를 설정
            if (i + A[i] > r) {
                r = i + A[i];
                p = i;
            }
        }

        // 가장 긴 팰린드롬의 길이 찾기
        int answer = 0;
        for (int i = 0; i < len; ++i) {
            answer = Math.max(answer, A[i]);
        }

        // 원래 문자열 기준으로 팰린드롬의 길이 출력
        System.out.println(answer);
        br.close();
    }
}