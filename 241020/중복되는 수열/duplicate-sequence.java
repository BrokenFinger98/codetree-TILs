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
    static String text, pattern;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        pattern = br.readLine();
        for(int i = 0; i < n-1; ++i){
            text = br.readLine();
            insertText(text);
        }
        System.out.println(findText(pattern));
        br.close();
    }

    static void insertText(String text){
        Node node = root;
        for(int i = 0; i < text.length(); i++){
            if(node.children[text.charAt(i) - '0'] == null){
                node.children[text.charAt(i) - '0'] = new Node();
            }
            node = node.children[text.charAt(i) - '0'];
        }
        node.isEnd = true;
    }

    static int findText(String text){
        Node node = root;
        int i;
        for(i = 0; i < text.length(); ++i){
            if(node.children[text.charAt(i) - '0'] != null){
                node = node.children[text.charAt(i) - '0'];
            }else break;
        }
        return i == text.length() ? 0 : 1;
    }
}