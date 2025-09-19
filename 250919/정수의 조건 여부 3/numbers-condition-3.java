import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        if(a % 13 == 0 || a % 19 == 0)
            System.out.println("True");
        else System.out.println("False");

        br.close();
    }
}