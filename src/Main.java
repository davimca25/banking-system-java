import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Bank bank = new Bank();

        System.out.println("Enter name:");
        String name = sc.nextLine();

        System.out.println("Enter cpf:");
        String cpf = sc.nextLine();


        User user = new User(name, cpf);

        Account account = bank.createAccount(user);


        bank.findAccountByNumber(account.getNumber());





    }
}