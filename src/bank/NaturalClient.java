package bank;

import java.util.ArrayList;
import java.util.List;

public class NaturalClient implements Client {

    private String name;
    private String surname;
    private int passportSeries;
    private int passportNumbers;

    List<Account> accountsList;


    public NaturalClient(String name, String surname, int passportSeries, int passportNumbers) {
        this.name = name;
        this.surname = surname;
        this.passportSeries = passportSeries;
        this.passportNumbers = passportNumbers;
        accountsList = new ArrayList<>(0);
    }

    public NaturalClient(String name, String surname, int passportSeries, int passportNumbers, List<Account> accountsList) {
        this.name = name;
        this.surname = surname;
        this.passportSeries = passportSeries;
        this.passportNumbers = passportNumbers;
        this.accountsList = accountsList;
    }

    public Account searchBankAccount(int id) {
        if(accountsList != null){
            for (Account account : accountsList) {
               if(account.getId() == id){
                   return account;
               }
            }
        }
        return null;
    }

    public List<Account> getAccountsList() {
        return accountsList;
    }

    public double totalBalanceAllAccounts(){
        double sum = 0;
        for(Account account : getAccountsList()){
            sum += account.getAccountBalance();
        }
        return sum;
    }

    public List<Account> getPositiveAccountList(){
        List<Account> accountsList = new ArrayList<>();
        for(Account account : getAccountsList()){
            if(account.getAccountBalance() > 0){
                accountsList.add(account);
            }
        }
        return accountsList;
    }

    public void deletingAccount(int id){
        int deleteAccountIndex = 0;
        for(Account account : accountsList){
            if(account.getId() == id){
                deleteAccountIndex = accountsList.indexOf(account);
            }
        }
        accountsList.remove(deleteAccountIndex);
    }

    public void addingBankAccount(Account account){
        accountsList.add(account);
    }

    public void reduceBankAccount(Account account, double amount){
        if(accountsList.contains(account)){
            account.replenishmentAccountBalance(amount);
        }
    }

    public void increaseBankAccount(Account account, double amount){
        if(accountsList.contains(account)){
            account.debitingTheAmount(amount);
        }
    }

    @Override
    public Account account(int id) {
        return null;
    }

    @Override
    public ArrayList<Account> allAccount() {
        return null;
    }

    @Override
    public ArrayList<Account> allDebitAccount() {
        return null;
    }

    @Override
    public ArrayList<Account> allCreditAccount() {
        return null;
    }

    @Override
    public double sumDebitAccountBalance() {
        return 0;
    }

    @Override
    public double sumAccruedInterest() {
        return 0;
    }

    @Override
    public double sumAccruedCommissions() {
        return 0;
    }

    @Override
    public double negativeCreditBalance() {
        return 0;
    }

    @Override
    public ArrayList<Account> positiveAccountBalance() {
        return null;
    }

    @Override
    public void removeAccount(int id) {

    }

    @Override
    public void addingAccount(Account account) {

    }

    @Override
    public void debitingAmountFromAccount(Account account, double amount) {

    }

    @Override
    public void addingAmountFromAccount(Account account, double amount) {

    }

    /*
- реализуйте методы интерфейса
     */
}