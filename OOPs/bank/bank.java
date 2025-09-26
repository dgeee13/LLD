package bank;

public class bank {
    public static void main(String[] args) {
        System.out.println("This is bank package");
        Account account1 = new Account();
        account1.name = "customer2";
        account1.email = "customer2@gmail.com";
        account1.setPassword("abcd");
        System.out.println("Password set for account1: " + account1.getPassword());
    }
}
