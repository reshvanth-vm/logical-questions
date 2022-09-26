import java.util.Scanner;

public class XYZBank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter card number without space >> ");
        String cardNo = sc.nextLine();

        System.out.print("Enter initial balance >> ");
        double balance = sc.nextDouble();

        BankAccount acc = new BankAccount(cardNo, balance);

        loop: while (true) {
            String[] query = sc.nextLine().split(" ");
            switch (query[0]) {
                case "Withdraw":
                    acc.withdraw(cardNo, Double.valueOf(query[1]));
                    break;
                case "ShowBalance":
                    acc.showBalance(cardNo);
                    break;
                case "Swipe":
                    acc.swipe(cardNo, Double.valueOf(query[1]));
                    break;
                case "Exit":
                case "exit":
                default:
                    break loop;
            }
        }

        sc.close();
    }
}
