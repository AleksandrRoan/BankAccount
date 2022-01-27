package bank;

import java.util.ArrayList;

public interface Client {
    public Account account(int id);

    public ArrayList<Account> allAccount();

    public ArrayList<Account> allDebitAccount();

    public ArrayList<Account> allCreditAccount();

    public double sumDebitAccountBalance();

    public double sumAccruedInterest();

    public double sumAccruedCommissions();

    public double negativeCreditBalance();

    public ArrayList<Account> positiveAccountBalance();

    public void removeAccount(int id);

    public void addingAccount(Account account);

    public void debitingAmountFromAccount(Account account, double amount);

    public void addingAmountFromAccount(Account account, double amount);
}
