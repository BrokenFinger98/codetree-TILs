import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int AMath = Integer.parseInt(st.nextToken()), AEnglish = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int BMath = Integer.parseInt(st.nextToken()), BEnglish = Integer.parseInt(st.nextToken());

        if(AMath > BMath && AEnglish > BEnglish)
            System.out.println(1);
        else System.out.println(0);

        br.close();
    }
}