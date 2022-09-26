public class BankAccount {
    private String cardNumber;
    private double balance;

    public BankAccount(String cardNumber, double initialBalance) {
        this.cardNumber = cardNumber;
        this.balance = initialBalance;
    }

    private void credit(double usd) {
        balance += usd;
    }

    private double chargeForWithdrawel(double usd) {
        return usd <= 100 ? usd / 50 : usd / 25; // 2% charge and 4%
    }

    private boolean isSufficientToDebit(double usd) {
        return balance - usd >= 100;
    }

    private void debit(double usd) {
        balance -= usd;
    }

    private boolean isValidCard(String cardNo) {
        if (cardNumber == cardNo)
            return true;
        System.out.println("Invalid Card Number");
        return false;
    }

    public void deposit(double usd) {
        balance += usd;
    }

    public void showBalance(String cardNo) {
        if (!isValidCard(cardNo))
            return;
        System.out.println("USD " + balance);
    }

    public void withdraw(String cardNo, double usd) {
        if (!isValidCard(cardNo))
            return;
        if (usd % 5 == 0) {
            double charges = chargeForWithdrawel(usd);
            if (isSufficientToDebit(usd + charges)) {
                debit(usd + charges);
                System.out.println("Charges USD " + charges);
                showBalance(cardNo);
            } else {
                System.out.println("Insufficient balance");
            }
        } else {
            System.out.println("Please correct the amount of value. It should be multiple of USD 5");
        }
    }

    public void swipe(String cardNo, double usd) {
        if (!isValidCard(cardNo))
            return;
        double cashback = usd / 100; // 1% cashback on swipe
        if (isSufficientToDebit(usd)) {
            credit(usd + cashback);
            System.out.println("Cashback USD " + cashback);
            showBalance(cardNo);
        } else {
            System.out.println("Insufficient balance");
        }
    }

}
