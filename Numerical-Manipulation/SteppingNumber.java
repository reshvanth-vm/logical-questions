import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SteppingNumber {
    public static void steppingNumbers(long num, long firstDigit, long[] range, List<Long> list) {
        if (num > range[1])
            return;

        if (num >= range[0] && num <= range[1] && num > 9
                && Math.abs(firstDigit - (num % 10)) == 1)
            list.add(num);

        long lastDigit = num % 10;
        num = num * 10 + lastDigit;
        if (lastDigit != 0)
            steppingNumbers(num - 1, firstDigit, range, list);
        if (lastDigit != 9)
            steppingNumbers(num + 1, firstDigit, range, list);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long[] range = new long[2];
        range[0] = sc.nextLong();
        range[1] = sc.nextLong();

        List<Long> list = new LinkedList<>();
        for (long i = range[0]; i < 10 && i <= range[1]; i++)
            list.add(i);

        for (long i = 1; i < 10; i++)
            steppingNumbers(i, i, range, list);

        if (list.isEmpty())
            System.out.println("No stepping numbers");
        else
            for (Long l : list)
                System.out.print(l + " ");
        System.out.println();

        sc.close();
    }
}
