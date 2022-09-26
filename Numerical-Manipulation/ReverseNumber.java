import java.util.Scanner;

public class ReverseNumber {

    public static long reverse(long n) {
        long res = 0;
        while (n > 0) {
            res = res * 10 + n % 10;
            n /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Reversed number is " + reverse(sc.nextLong()));
        sc.close();
    }
}
