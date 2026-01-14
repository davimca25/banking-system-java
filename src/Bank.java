import java.util.List;
import java.util.ArrayList;

public class Bank {

    private List<Account> accounts = new ArrayList<>();
    private int nextAccountNumber = 1;

    public Account createAccount(User user) {
        if (findAccountByCpf(user.getCpf()) != null) {
            throw new IllegalArgumentException("CPF already registered");
        }
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
    public Account findAccountByCpf(String cpf) {
        for (Account acc : accounts) {
            if (acc.getUser().getCpf().equals(cpf)) {
                return acc;
            }
        }
        return null;
    }
    public void transferMoney(Account from, Account to, double amount) {
        if (from == null || to == null) {
            throw new IllegalArgumentException("Invalid account");
        } else if (from == to) {
            throw new IllegalArgumentException("Cannot transfer money between same accounts");
        } else if (amount <= 0) {
            throw new IllegalArgumentException("Invalid amount");
        } else if (!from.isStatus() || !to.isStatus()) {
            throw new IllegalArgumentException("Account is not active");
        } else if (from.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        from.debit(amount);
        to.credit(amount);

        from.addTransaction("TRANSFER_OUT", amount);
        to.addTransaction("TRANSFER_IN", amount);
    }

}
