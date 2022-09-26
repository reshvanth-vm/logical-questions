import java.util.Scanner;

public class NextGreaterNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = sc.nextInt();
        
        for (int i = 0; i < size; i++) {
            int greater = -1;
            for (int j = i + 1; j < size; j++)
                if (arr[i] < arr[j])
                    greater = arr[j];
            arr[i] = greater;
        }
        
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");

        sc.close();
    }
}
