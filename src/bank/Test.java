package bank;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        Account account1 = new Account(1, 300);
        Account account2 = new Account(2, 1300);
        Account account3 = new Account(3, -300);
        List<Account> accountList = new ArrayList<>();
        accountList.add(account1);
        accountList.add(account2);
        Client client = new Client("Alex", "Chalyy", 3610, 395078, accountList);
        System.out.println(client.searchBankAccount(1).getAccountBalance());
        System.out.println(accountList);
        System.out.println(client.totalBalanceAllAccounts());
        System.out.println(client.getPositiveAccountList());
        client.deletingAccount(1);
        System.out.println(client.getAccountsList());
        client.addingBankAccount(account3);
        System.out.println(client.getAccountsList());
        client.increaseBankAccount(account2,100);
        System.out.println(account2.getAccountBalance());
        client.reduceBankAccount(account2,200);
        System.out.println(account2.getAccountBalance());
    }
}
