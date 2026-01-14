import java.util.ArrayList;
import java.util.List;

public class Account {
    private final int number;
    private double balance;
    private boolean status;
    private final User user;
    private List<Transactions> history = new ArrayList<>();

    public Account(int number, User user) {
        this.number = number;
        this.user = user;
        this.balance = 0.0;
        this.status = true;
    }

    public int getNumber() {
        return number;
    }

    public double getBalance() {
        return balance;
    }

    public User getUser() {
        return user;
    }   

    public boolean isStatus() {
        return status;
    }

    public void deposit(double value) {
        if (!status) {
            throw new IllegalStateException("Account is blocked");
        }
        if (value <= 0) {
            throw new IllegalArgumentException("Invalid deposit value");
        }
        balance += value;
        history.add(new Transactions("DEPOSIT", value));
    }

    public void withdraw(double value) {
        if (!status) {
            throw new IllegalStateException("Account is blocked");
        }
        if (value <= 0) {
            throw new IllegalArgumentException("Invalid withdraw value");
        }
        if (value > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance -= value;
        history.add(new Transactions("WITHDRAW", value));
    }

    public void block() {
        this.status = false;
    }

    public void activate() {
        this.status = true;
    }

    public void showHistory() {
        for (Transactions t : history) {
            System.out.println(t);
        }
    }
}

