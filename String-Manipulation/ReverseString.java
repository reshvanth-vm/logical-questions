import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        int size = str.length();
        char[] reversedStr = new char[size];
        for (int i = 0; i < size; i++)
            reversedStr[i] = str.charAt(size - 1 - i);
        
        System.out.println(reversedStr);

        sc.close();
    }
}
