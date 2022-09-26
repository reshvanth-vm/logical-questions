import java.util.Scanner;

public class KthElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = sc.nextInt();
        int k = sc.nextInt();
        
        int max = Integer.MIN_VALUE, prevMax = Integer.MAX_VALUE; 
        int min = Integer.MAX_VALUE, prevMin = Integer.MIN_VALUE;
        while (k-- > 0) {
            min = prevMax;
            max = prevMin;
            for (int i = 0; i < size; i++) {
                if (arr[i] < min && arr[i] > prevMin)
                    min = arr[i];
                if (arr[i] > max && arr[i] < prevMax)
                    max = arr[i];
            }
            prevMax = max;
            prevMin = min;
        }

        System.out.println(min + " " + max);

        sc.close();
    }
}
