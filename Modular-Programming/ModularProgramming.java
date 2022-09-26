import java.util.Scanner;

public class ModularProgramming {
    public static int digitsSum(int num) {
        if (num < 10)
            return num;
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }
        return digitsSum(res);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int y = sc.nextInt();

        boolean hasTrap = false;
        for (int x = n1, i; x <= n2; x++) {
            if (x % y == 0 || y % x == 0 ||
                    (y % (i = digitsSum(x)) == 0) || i % y == 0) {
                System.out.print(x + " ");
                hasTrap = true;
                y += 2;
            } else
                y = y <= 3 ? 3 : y - 1;
        }

        if (!hasTrap)
            System.out.println("NONE");

        sc.close();
    }
}
