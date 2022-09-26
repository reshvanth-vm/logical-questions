import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Justification {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < n; i++)
            words[i] = sc.next();
        int l = sc.nextInt();
        
        List<String> lines = new LinkedList<>();
        int currLen = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            currLen += words[i].length() + 1;
            if (currLen > l) {
                if (currLen - 1 == l) {
                    String s = "";
                    for (int j = start; j < i - 1; j++)
                        s += words[j] + " ";
                    s += words[i - 1];
                    lines.add(s);
                    currLen = 0;
                    start = i + 1;
                    continue;
                }
                currLen -= words[i].length() + 1;
                i--;
                int wordsCount = (i - start) + 1;
                currLen -= wordsCount;
                int spaceCount = l - currLen;
                int rem = spaceCount % (wordsCount - 1);
                for (int o = 0, j = start; o < rem; o++) {
                    if (j >= i) j = start;
                    words[j] += " ";
                    j++;
                }
                int divides = spaceCount / (wordsCount - 1);
                String space = "", s = "";
                for (int j = 0; j < divides; j++)
                    space += " ";
                for (int j = start; j < i; j++)
                    s += words[j] + space;
                s += words[i];
                lines.add(s);
                start = i + 1;
                currLen = 0;
            }
        }

        if (currLen != 0) {
            String s = "";
            for (int j = start; j < n; j++)
                s += words[j] + " ";
            int spaceCount = l - currLen;
            for (int j = 0; j < spaceCount; j++)
                s += " ";
            lines.add(s);
        }
        System.out.println("[");
        for (int i = 0; i < lines.size() - 1; i++)
            System.out.println("\"" + lines.get(i) + "\",");
        System.out.println("\"" + lines.get(lines.size() - 1) + "\"");
        System.out.println("]");

        sc.close();
    }
}
