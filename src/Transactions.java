import java.time.LocalDateTime;

public class Transactions {
    private String type;      // "DEPOSIT", "WITHDRAW", "TRANSFER"
    private double amount;
    private LocalDateTime date;

    public Transactions(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.date = LocalDateTime.now();
    }
    public String toString() {
        return date + " | " + type + " | $" + amount;
    }
}
