import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static class Node{
        Node[] children = new Node[10];
        boolean isEnd;
        public Node(){
            isEnd = false;
            for(int i = 0; i < 10; ++i){
                children[i] = null;
            }
        }
    }
    static Node root = new Node();
    static int n;
    static String text;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; ++i){
            text = br.readLine();
            if(insertText(text) == 0) {
                System.out.println(0);
                System.exit(0);
            }
        }
        System.out.println(1);
        br.close();
    }

    static int insertText(String text){
        Node node = root;
        for(int i = 0; i < text.length(); i++){
            if(node.isEnd) return 0;
            if(node.children[text.charAt(i) - '0'] == null){
                node.children[text.charAt(i) - '0'] = new Node();
            }
            node = node.children[text.charAt(i) - '0'];
        }
        node.isEnd = true;
        return 1;
    }

    static int findText(String text){
        Node node = root;
        int i;
        for(i = 0; i < text.length(); ++i){
            if(node.children[text.charAt(i) - '0'] == null) return 1;
            node = node.children[text.charAt(i) - '0'];
        }
        return 0;
    }
}