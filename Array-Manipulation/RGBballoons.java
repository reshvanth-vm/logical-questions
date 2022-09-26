import java.util.Scanner;

public class RGBballoons {
    public static int compareRGB(char a, char b) {
        if (a == 'R') {
            if (b != 'R')
                return -1;
        } else if (a == 'G') {
            return b == 'R' ? 1 : b == 'B' ? -1 : 0;
        } else if (b != 'B') {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        char[] arr = new char[size];
        for (int i = 0; i < size; i++)
            arr[i] = sc.next().charAt(0);

        for (int i = 1; i < size; i++) {
            char temp = arr[i];
            int j = i;
            for (; j > 0 && compareRGB(temp, arr[j - 1]) < 0; j--)
                arr[j] = arr[j - 1];
            arr[j] = temp;
        }
        
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");

        sc.close();
    }
}
