import java.util.Scanner;

public class ConsoleUI {
    public static void start() {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();
        Account currentAccount = null;
        boolean runningUI = true;


        while (runningUI) {
            System.out.println("-----------------");
            System.out.println(" WELCOME TO BANK ");
            System.out.println("-----------------");
            System.out.println("1 - Create account\n");
            System.out.println("2 - Deposit\n");
            System.out.println("3 - Withdraw\n");
            System.out.println("4 - Show balance\n");
            System.out.println("5 - Exit");
            System.out.println("-----------------");
            System.out.print("Enter option: ");
            String option = sc.nextLine();
            switch (option) {
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
                    if (currentAccount == null) {
                        System.out.println("No account. Create one first.");
                        break;
                    }
                    try {
                        System.out.print("Value to deposit: ");
                        double value = Double.parseDouble(sc.nextLine());
                        currentAccount.deposit(value);
                        System.out.println("Deposit successful.");
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid number.");
                    } catch (Exception e) {
                        System.err.println("Error: " + e.getMessage());
                        break;
                    }
                    break;
                case "3":
                    if (currentAccount == null) {
                        System.out.println("No account. Create one first.");
                        break;
                    }
                    try {
                        System.out.print("Value to withdraw: ");
                        double value = Double.parseDouble(sc.nextLine());
                        currentAccount.withdraw(value);
                        System.out.println("Withdraw successful.");
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid number.");
                    } catch (Exception e) {
                        System.err.println("Error: " + e.getMessage());
                        break;
                    }
                    break;
                case "4":
                    if (currentAccount == null) {
                        System.out.println("No account. Create one first.");
                        break;
                    }
                    System.out.println("$" + currentAccount.getBalance());
                    break;
                case "5":
                    System.out.println("Exiting...");
                    runningUI = false;
                    break;
                default:
                    System.out.println("Invalid Option. Try again.");







            }
        }
    }
}