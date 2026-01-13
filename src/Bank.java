import java.util.List;
import java.util.ArrayList;

public class Bank {

    private List<Account> accounts = new ArrayList<>();
    private int nextAccountNumber = 1;

    public Account createAccount(User user) {
        Account account = new Account(nextAccountNumber, user);
        accounts.add(account);
        nextAccountNumber++;
        return account;
    }

    public Account findAccountByNumber(int number) {
        for (Account acc : accounts) {
            if (acc.getNumber() == number) {
                return acc;
            }
        }
        return null;
    }
    public void showAccounts() {
        for (Account acc : accounts) {
            System.out.println(
                    "Account " + acc.getNumber() +
                            " | " + acc.getUser() +
                            " | Balance: " + acc.getBalance()
            );
        }
    }

}
