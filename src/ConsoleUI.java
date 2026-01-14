import java.util.Scanner;

public class ConsoleUI {
    public static void start() {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();
        Account currentAccount = null;
        boolean login = true;
        boolean runningUI = false;

        while (true) {

            // ===== LOGIN MENU =====
            while (login) {
                System.out.println("------------------");
                System.out.println("1 - Create account");
                System.out.println("2 - Login");
                System.out.println("3 - Exit");
                System.out.println("------------------");
                String option1 = sc.nextLine();

                switch (option1) {
                    case "1":
                        try {
                            System.out.println("Enter name:");
                            String name = sc.nextLine();

                            System.out.println("Enter cpf:");
                            String cpf = sc.nextLine();

                            User user = new User(name, cpf);
                            currentAccount = bank.createAccount(user);

                            System.out.println(currentAccount.getUser());
                            System.out.println("Account created successfully.");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case "2":
                        System.out.println("Enter cpf:");
                        String cpf = sc.nextLine();
                        Account acc = bank.findAccountByCpf(cpf);

                        if (acc == null) {
                            System.out.println("Account not found.");
                        } else {
                            currentAccount = acc;
                            System.out.println("Logged in as: " + acc.getUser().getName());
                            login = false;
                            runningUI = true;
                        }
                        break;

                    case "3":
                        return;

                    default:
                        System.out.println("Invalid Option. Try again.");
                }
            }

            // ===== ACCOUNT MENU =====
            while (runningUI) {
                System.out.println("-----------------");
                System.out.println("    WELCOME");
                System.out.println("-----------------");
                System.out.println("1 - Deposit");
                System.out.println("2 - Withdraw");
                System.out.println("3 - Show balance");
                System.out.println("4 - Show history");
                System.out.println("5 - Exit");
                System.out.println("-----------------");

                String option2 = sc.nextLine();

                switch (option2) {
                    case "1":
                        try {
                            double value = Double.parseDouble(sc.nextLine());
                            currentAccount.deposit(value);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case "2":
                        try {
                            double value = Double.parseDouble(sc.nextLine());
                            currentAccount.withdraw(value);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case "3":
                        System.out.println(currentAccount.getBalance());
                        break;

                    case "4":
                        currentAccount.showHistory();
                        break;

                    case "5":
                        runningUI = false;
                        login = true;
                        currentAccount = null;
                        break;

                    default:
                        System.out.println("Invalid Option");
                }
            }
        }
    }
}
