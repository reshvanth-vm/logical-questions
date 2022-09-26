import java.util.Scanner;

public class RepeatingSubstring {
    public static char ch(char c) {
        if (c >= 65 && c <= 90)
            return (char)(c + 32);
        return c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        int size = s.length();
        int repeatedSubStrs = 0;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (ch(s.charAt(i)) == ch(s.charAt(j))) {
                    int len = 0, k = i, l = j;
                    while (k < j && l < size && ch(s.charAt(k)) == ch(s.charAt(l))) {
                        len++;
                        k++;
                        l++;
                    }
                    if (len >= 2) {
                        if (repeatedSubStrs > 0)
                            System.out.print(", ");
                        for (int m = i; m < i + len; m++)
                            System.out.print(s.charAt(m));
                        repeatedSubStrs++;
                        i = i + len - 1;
                        break;
                    }
                }
            }
        }
        
        if (repeatedSubStrs == 0)
            System.out.println("none");

        sc.close();
    }
}
