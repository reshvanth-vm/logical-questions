import java.util.Scanner;

public class LongestBinarySubArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = sc.nextInt();
        
        int start = 0, total = 0, len = 0;
        for (int i = 0; i < size - 1; i++) {
            total = arr[i] == 1 ? 1 : -1;
            for (int j = i + 1; j < size; j++) {
                total += arr[j] == 1 ? 1 : -1;
                if (total == 0 && len < j - i + 1) {
                    len = j - i + 1;
                    start = i;
                }
            }
        }

        System.out.println(len <= 0
                ? "No sub-array found"
                : start + " to " + (start + len - 1));

        sc.close();
    }
}
